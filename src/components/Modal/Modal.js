import React from 'react'
import { useRef } from 'react'
const Modal = ({children,open,classname= ''}) => {
    const dialog=useRef();
    useEffect(()=>
    {
       if(open)
        {
            dialog.current.showModal();
        }
    },[open])
  return createPortal  (
    <dialog ref={dialog} className={'modal ${className}'}>{children}</dialog>,
    document.getElementById('modal')
  );
}

export default Modal
