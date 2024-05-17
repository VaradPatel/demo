import { computeHeadingLevel } from '@testing-library/react'
import React from 'react'
import { useSelector } from 'react-redux'
const Carts = () => {
  const products = useSelector((state) => state.product);
  const UserProgress=useSelector((state)=>state.userProgress);
  const cartTotal = products.items.reducer((totalPrice, item) => totalPrice + item.quantity * item.price,0);
  return (
    <Modal className="cart" open={UserProgress.progress==='cart'}>
      <ul>
        {products.items.map((item)=>(
          <li key={item.id}>
            {item.name}-{item.quantity}
          </li>
        ))}
      </ul>
      <p className="cart-total">{cartTotal}</p>
      <p className="modal-actions">
        <button> close</button>
      </p>
    </Modal>
  )
}

export default Carts
