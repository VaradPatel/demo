import React, { useId } from 'react';
import { useFormik } from 'formik';
import * as Yup from 'yup';
import './login.css'
import { useDispatch } from 'react-redux';
import { login } from '../redux/UserSlice';
import { redirect } from "react-router-dom";
import { useNavigate } from 'react-router-dom';

const Login = () => {
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const formik = useFormik({
        initialValues: {
            firstName: '',
            lastName: '',
            email: '',
            password:''
        },
        validationSchema: Yup.object({
            firstName: Yup.string()
                .max(15, 'Must be 15 characters or less')
                .required('Required'),
            lastName: Yup.string()
                .max(20, 'Must be 20 characters or less')
                .required('Required'),
            email: Yup.string().email('Invalid email address').required('Required'),
            password: Yup.string().max(15,'Must be 15 characters or less').matches(
                /^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*(),.?":{}|<>]).{1,}$/,
                'Password must contain at least one uppercase letter, one lowercase letter, and one special character'
              )
              .required('Password is required')
        }),
        onSubmit: values => {
           
            const verifyuser = async () => {
                try{
                    const response=await fetch('http:localhost:8080/login',
                {
                    headers:
                    {
                     'Content-Type':'application/json',
                    }
                    ,
                    body:JSON.stringify({
                        email:values.email,
                        password:values.password,
                    }),
                })
                if(response.ok)
                {

                    console.log('sucessfully logged in');
                    const {id,jwtToken}=await response.json();
                    localStorage.setItem('jwtToken',jwtToken);
                    localStorage.setItem('userId',id);
                    dispatch(login({id}));

                    alert(JSON.stringify(values, null, 2));
                     
                    navigate('/home');
                }
                else{
                    console.log("invalid request");
                }
                }
                catch(Error)
                {
                   throw new Error(Error);
                }
            }
            verifyuser();
            
           // Example user ID, replace with real logic if needed
           
        },
    });
    return (
        <div className='form'>
            <form onSubmit={formik.handleSubmit} >
                <div>
                    <label htmlFor="firstName" className='value' >First Name</label>
                    <input
                        id="firstName"
                        name="firstName"
                        type="text"
                        onChange={formik.handleChange}
                        onBlur={formik.handleBlur}
                        value={formik.values.firstName}
                    />
                    {formik.touched.firstName && formik.errors.firstName ? (
                        <div class='error'>{formik.errors.firstName}</div>
                    ) : null}

                </div>
                <div>
                    <label htmlFor="lastName" className='value'>Last Name</label>
                    <input
                        id="lastName"
                        name="lastName"
                        type="text"
                        onChange={formik.handleChange}
                        onBlur={formik.handleBlur}
                        value={formik.values.lastName}
                        className='bg-red-700'
                    />
                    {formik.touched.lastName && formik.errors.lastName ? (
                        <div class='error'>{formik.errors.lastName}</div>
                    ) : null}

                </div>
                <div>
                    <label htmlFor="email">Email Address</label>
                    <input
                        id="email"
                        name="email"
                        type="email"
                        onChange={formik.handleChange}
                        onBlur={formik.handleBlur}
                        value={formik.values.email}
                    />
                    {formik.touched.email && formik.errors.email ? (
                        <div class='error'>{formik.errors.email}</div>
                    ) : null}
                </div>
                <div>
                    <label htmlFor="password" className='value' >password</label>
                    <input
                        id="password"
                        name="password"
                        type="text"
                        onChange={formik.handleChange}
                        onBlur={formik.handleBlur}
                        value={formik.values.password}
                    />
                    {formik.touched.password && formik.errors.password ? (
                        <div class='error'>{formik.errors.password}</div>
                    ) : null}

                </div>



                <button type="submit">Submit</button>
            </form>
        </div>
    );
};
export default Login;