import React from 'react';
import './App.css';
import Login from './components/Login/Login';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import { Provider } from 'react-redux';
import store from './components/redux/index.js'; // Correct path to the store
import Home from './components/home/home.js';
import Product from './components/Product/product.js';
import Headers from './components/headers/headers.js';

const router = createBrowserRouter([
  {
    path: '/login',
    element: <Login />
  },
  {
    path: '/home',
    element: <Home />
  },
  {
    path:'/product',
    element:<Product />
  }
]);

function App() {
  return (
    <Provider store={store}>
    <Headers/>
      <RouterProvider router={router} />
      
    </Provider>
  );
}

export default App;
