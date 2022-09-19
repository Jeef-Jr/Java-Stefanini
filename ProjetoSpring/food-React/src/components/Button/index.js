import React from 'react'
import "./style.css";

export default function Button(props) {
  return (
    <> 
      {props.status == true && (
        <a href={props.href} onClick={props.click}>
          <div className={props.class}>{props.nome}</div>
      </a>
      )}   
      {props.status == false && (
          <div onClick={props.click} className={props.class}>{props.nome}</div>
    )}   
    </>

  )
}
