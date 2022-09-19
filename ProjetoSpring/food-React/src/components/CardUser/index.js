import React from 'react'
import Button from "../Button"
import "./style.css"
export default function CardUser(props) {

  return (
      <div id='cardUser' onClick={props.click}>
        <img className='imgUser' src={props.img}/>
        <div>
          <p>{props.nome}</p>
        </div>
        <div className='row'>
          <Button nome="Deletar" status={false} click={props.clickDell} class="buttonDelete"/> 
          <Button nome="Atualizar" status={false}  click={props.clickAtt} class="buttonUpdate"/> 
        </div>
      </div>
  )
}
