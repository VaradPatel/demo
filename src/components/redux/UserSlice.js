import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  loggedIn: false,
  userId: ''
};

const userSlice = createSlice({
  name: 'user',
  initialState,
  reducers: {
    login(state, action) {
      state.loggedIn = true;
      console.log(action.payload);
      state.userId = action.payload.userId;
    },
    logout(state) {
      state.loggedIn = false;
      state.userId = '';
    }
  }
});

export const { login, logout } = userSlice.actions;
export default userSlice.reducer;
