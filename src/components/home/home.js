import { Link } from 'react-router-dom';
import Product from '../Product/product';
import { useSelector } from 'react-redux';
import { useEffect } from 'react';


const Home = () => {
    const data = useSelector((state) => state?.product);

    useEffect(() => {
        const getproduct = async () => {
            try {
                const token = localStorage.getItem('jwtToken')
                const response = await fetch('URL',
                    {
                        headers: {
                            'Content-Type': 'application/json',
                            'Authorization': 'bearer ' + token,
                        }
                    })
                if (response.ok) {
                    const data = response.json();
                    console.log(data);
              
                }
                else {
                    console.log(" get cart request failure ");
                }
            }
            catch (error) {

            }

        }

        getproduct();
    })
    const products = [
        {
            id: 1,
            name: "item1",
            quantity: 1,
            price: 100,
        },
        {
            id: 2,
            name: "item2",
            quantity: 1,
            price: 100,
        },
        {
            id: 3,
            name: "item3",
            quantity: 1,
            price: 100,
        }
    ];

    return (
        <div>
            <h1>Home Page</h1>
            {products?.map((item, index) => (
                <Product key={item.id} item={item} />
            ))}
        </div>
    );
}

export default Home;
