import { createSlice } from '@reduxjs/toolkit'
import React from 'react'
const initialState={
    progress:''
}
const UserProgressContext=createSlice(
    {
        name:'UserProgressContext',
        initialState:initialState,
        reducers:
        {
            showCart(state)
            {
               state.progress="cart"
            },
            hideCart(state)
            {
        state.progress=''
            },
            showCheckout(state)
            {
              state.progress='checkout'
            },
            hideCheckout(state)
            {
state.progress=''
            }

        }
    }
)
const userProgress=UserProgressContext.actions;
export {userProgress};

export default UserProgressContext.reducer
