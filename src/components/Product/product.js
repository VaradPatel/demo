import { useState } from "react";
import { useDispatch } from "react-redux";
import { ProductAction } from "../redux/productSlice";
import { useSelector } from "react-redux";
const Product = ({ item }) => {
    const data = useSelector((state) => state?.product);
    console.log("data is" + data?.totalQuantity);
    const dispatch = useDispatch();
    const [quantity, setquantity] = useState(0);
    console.log("props are" + item?.name);
    const handleClick = (e) => {
        setquantity(quantity + 1);
        const additems = { ...item, quantity };

        dispatch(ProductAction.add(additems));

        const token = localStorage.getItem('jwtToken');
        const id = localStorage.getItem('userId');

        const postData = async () => {
            try {
                const response = await fetch(`http://localhost:8080/addtocart/${id}`, {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': 'Bearer ' + token,
                    },
                    body: JSON.stringify(),
                });
                if (response.ok) {

                    console.log('Data posted successfully');
                } else {

                    console.error('Failed to post data:', response.statusText);
                }
            } catch (error) {
                console.error('Error posting data:', error);
                throw new Error(error);
            }
        };
        postData();

    }
    const handleDelete = (e) => {
        setquantity(quantity - 1);

        dispatch(ProductAction.delete(item.id));
    }


    return (
        <div>
            <h1>{item.id}</h1>
            <h1>{item.name}</h1>
            <h1>{item.price}</h1>
            <h1> current quantity is {quantity}</h1>

            <button type="button" onClick={handleClick}> click here to add item</button>
            <button type="button" onClick={handleDelete}>click here to remove item</button>
            <br></br>

        </div>

    )
}
export default Product;
