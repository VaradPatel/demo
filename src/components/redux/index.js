import { configureStore } from '@reduxjs/toolkit';
import userReducer from './UserSlice';  // Correctly import the reducer
import productSlice from './productSlice';

const store = configureStore({
  reducer: {
    user: userReducer ,
    product:productSlice // Ensure the key matches the slice name
  }
});

export default store;
