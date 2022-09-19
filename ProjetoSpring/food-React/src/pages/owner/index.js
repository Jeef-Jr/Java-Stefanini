import axios from 'axios'
import React, { useEffect, useState } from 'react'
import Swal from 'sweetalert2'
import Button from '../../components/Button'
import CardUser from '../../components/CardUser'
import Input from '../../components/Input'
import "./style.css"

export default function Owner() {

  const [owner, setOwner] = useState([]);
  const [ownerOne, setOwnerOne] = useState([]);
  const [statusForm, setStatusForm] = useState(false);


  // FORM
  const [nome, setNome] = useState("");
  const [endereco, setEndereco] = useState("");
  const [email, setEmail] = useState("");
  const [imagem, setImagem] = useState("");


  function buscarOwners(){
    axios.get("http://localhost:8080/usuarios")
    .then((response => {
      setOwner(response.data)
    }))
  }

  function buscarOwnersOne(id){
    axios.get(`http://localhost:8080/usuarios/${id}`)
    .then((response => {
      setOwnerOne(response.data)
    }))
  }

  function deletarUser(id){
   
    axios.delete(`http://localhost:8080/usuarios/${id}`)
    .then((response => {
      
      if(response.status === 200){
        Swal.fire(
          `Usuário com ID(${id}) foi deletado.`,
          '',
          'success'
        )
      }else {
        Swal.fire(
          `Não foi possivel deletar o usuário com o ID(${id}).`,
          'Deu algum erro no sistema',
          'error'
        )
      }

      buscarOwners();
    })).catch(erro => {
      Swal.fire(
        erro,
        'Deu algum erro no sistema',
        'error'
      )
    })
  }

  function atualiza(id){
    buscarOwnersOne(id)
    setStatusForm(!statusForm)

    



  }

  function exitAtt(){
    setStatusForm(statusForm == false)
  }

useEffect(() => {
  buscarOwners();
},[])

  return (
    <div id='containerOwner'>
       <img className='logo' src='https://i.imgur.com/HPafyl6.gif' />
       {!statusForm && (
         <Button nome="+ Owner" status={false} class="button1" />
       )}
       {statusForm && (
        <div className='borderForm'>
            <Input place="Nome" value={nome} change={(e) => setNome(e.target.value)}/>
            <Input place="Endereço" value={endereco} change={(e) => setEndereco(e.target.value)}/>
            <Input place="Email" value={email} change={(e) => setEmail(e.target.value)}/>
            <Input place="URL Imagem" value={imagem} change={(e) => setImagem(e.target.value)}/>
            <div className='row'>
                <Button nome="<- Voltar" click={exitAtt} status={false} class="buttonUpdate"/>
                <Button nome="Atualizar" status={false} class="buttonUpdate"/>
            </div>
        </div>  
       )}
        
       <div className='row'>
        {!statusForm && (
          <>
           {owner && owner.length > 0 && (
            <>
            {owner?.map((d, index) => (
              <div key={index}>
              <CardUser nome={d.nome} clickDell={() => deletarUser(d.id)} 
              clickAtt={() => atualiza(d.id)} img={d.imagem} />
              </div>
            ))}
            </>
          )}
          </>
        )}
       </div>
    </div>
  
  )
}
