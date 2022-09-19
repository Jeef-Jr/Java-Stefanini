import React from 'react'
import "./style.css";

export default function Input(props) {
  return (
   <input type={props.type} value={props.value} 
   onChange={props.change} className='inputForm' placeholder={props.place} />
  )
}
