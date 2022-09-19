import React from 'react'
import Button from '../../components/Button';
import "./style.css";
 function Home() {
  return (
    <div id='containerHome'>
        <div>
            <img src='https://i.imgur.com/iLMKPJT.png'/>
        </div>
        <Button class="button1" status={true}  nome="Acessar" href="/owner" />
    </div>
  )
}

export default Home;