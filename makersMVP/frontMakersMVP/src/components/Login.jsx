import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import { endpoints } from '../resources/endpoints'
import Home from './Home'

const Login = () => {
    const [userData, setUserData] = useState({})
    const [validUser, setValidUser] = useState(false)
    const handleLogin = (e) => {
        e.preventDefault()
        fetch(endpoints.login, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(userData)
        })
         .then(res => res.json())
         .then(data => {
            if (data) {
                sessionStorage.setItem('userEmail',`${userData.userEmail}`)
                setTimeout(setValidUser(true),3000)
            }
            else {
                {/*alerta de user invalido con librerai de notificaciones de react*/}
            }
         })
        }
  return (
    <div>
        {validUser ? <Home/> :
        <div>
            <h1>BLOCKSAVVY</h1>
            <div>
                <form action="submit" onSubmit={handleLogin}>
                    <div>
                        <label>email</label>
                        <input type='email' placeholder='log in with your email' onChange={(e)=> {setUserData({...userData, userEmail: e.target.value})}}/>
                    </div>
                    <div>
                        <label>password</label>
                        <input type='password' placeholder='user password' onChange={(e)=> {setUserData({...userData, password: e.target.value})}}/>
                    </div>
                    <div>
                        <button>LOG IN</button>
                    </div>
                </form>
            </div>
            <div>
                <p>don't have an account yet? <Link to='/signup'>SIGN UP!</Link></p>
            </div>
        </div>}
    </div>
  )
}


export default Login