import { createSlice } from "@reduxjs/toolkit";
const initialState =
{
    items: [],
    totalQuantity: 0,
    
}
const ProductSlice = createSlice(
    {
        name: 'productSlice',
        initialState,
        reducers:
        {
            add(state, action) {
                console.log("payload in additem" + action.payload);
                const additem = action.payload;
                console.log("additem is"+ additem.name);
                state.totalQuantity++;
               const existingItem= state.items.find(item=>
                {
                    return item.id===additem.idl
                });
              if(!existingItem)
              {
                state.items.push(
                    {
                     id:additem.id,
                     name:additem.name,
                     price:additem.price,
                     quantity:1,
                     totalPrice:additem.totalPrice,

                    }
                );
              }
              else{
                existingItem.quantity++;
                existingItem.totalPrice=existingItem.totalPrice+existingItem.price;
              }
               
            },
            delete(state, action) {
                console.log("payload in additem" + action.payload);
           const id=action.payload;
           state.totalQuantity--;
           const deleteitem=state.items.find(item=>
        {
return item.id===id;
        });
        if(deleteitem.quantity===1)
        {
            state.items=state.items.filter(item=>item.id!==id)
        }
        else
        {
            deleteitem.quantity--;
            deleteitem.totalPrice=deleteitem.totalPrice-deleteitem.price;
            state.items={...state.items, deleteitem};
        }
            }
        }
    }
)
const ProductAction = ProductSlice.actions;
export { ProductAction }
export default ProductSlice.reducer;