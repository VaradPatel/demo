import React from 'react'
import logoimg from '../assests/logo.jpg'
const Headers = () => {
  return (
    <header id="main-header">
        <div id="title">
            <img src={logoimg} alt="A restaurant" />
            <h1>  ReactFood </h1>
        </div>
    </header>
  )
}

export default Headers

