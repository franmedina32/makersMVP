import React, { useEffect, useState } from 'react'
import { endpoints } from '../resources/endpoints'
import NavbarComp from './NavbarComp'

const Home = () => {
    const [userData, setUserData] = useState()
    const [favCollections, setFavCollections] = useState()
    useEffect(()=>{
        const uEmail = sessionStorage.getItem('userEmail')
        fetch(endpoints.findUserByEmail,{
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                userEmail: `${uEmail}`
            })
        })
         .then(res => res.json())
         .then(data => setUserData(data))
    },[])
  return (

    <div>
        <NavbarComp/>
        <div>
            <form action='submit'>
                <input type="text" placeholder='search by contract address'/>
                <button type='submit'>🔍</button>
            </form>
            <div>
            </div>
        </div>
    </div>
  )
}

export default Home