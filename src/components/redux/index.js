import { configureStore } from '@reduxjs/toolkit';
import userReducer from './UserSlice';  // Correctly import the reducer
import productSlice from './productSlice';
import UserProgressContext from './UserProgressContext';
const store = configureStore({
  reducer: {
    user: userReducer ,
    product:productSlice,
    userProgress:UserProgressContext
  }
});

export default store;
