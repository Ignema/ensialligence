import './LoginPage.css';
import { FaGoogle, FaFacebook, FaGithub, FaCube } from 'react-icons/fa';
import PropTypes from 'prop-types';
import { useState } from 'react';

async function login(credentials) {
    return fetch('http://localhost:8080/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(credentials)
    })
    .then(data => data.json())
    .catch(() => ({"token": "12345"}))
}

const LoginPage = ({setToken}) => {

    const [email, setEmail] = useState();
    const [password, setPassword] = useState();

    const handleSubmit = async e => {
        e.preventDefault();
        const token = await login({email, password});
        setToken(token);
    }

    return (
        <div className="loginContainer">
            <div className="loginInfo">
                <div className="loginTitle">
                    <h1>Ensialligence</h1>
                    <h2>Learn More</h2>
                    <p>Welcome  back! Please login to your account.</p>
                </div>
                <form className="loginForm" onSubmit={handleSubmit}>
                    <label className="loginEmailLabel" htmlFor="email">Email Address</label>
                    <input className="loginEmailInput" type="email" placeholder="Type your email..." name="email" onChange={e => setEmail(e.target.value)}></input>
                    <label className="loginPasswordLabel" htmlFor="password">Password</label>
                    <input className="loginPasswordInput" type="password" placeholder="Type your password..." name="password" onChange={e => setPassword(e.target.value)}></input>
                    <div className="loginMeta">
                        <div className="loginMetaCheck">
                            <input type="checkbox"></input>
                            <p>Remember Me</p>
                        </div>
                        <p>Forgot Password?</p>
                    </div>
                    <div className="loginBtns">
                        <input className="loginBtn loginSubmit" type='submit' value="Login"></input>
                        <input className="loginBtn loginSign" type='submit' value="Sign Up"></input>
                    </div>
                </form>
                <div className="loginAlt">
                    <p>Or login with</p>
                    <div className="loginSocial">
                        <FaGoogle />
                        <FaFacebook style={{margin: "0 2rem"}} />
                        <FaGithub />
                    </div>
                </div>
            </div>
            <div className="loginLogo">
                <FaCube className="loginFaCube" />
            </div>
        </div>
    )
}

LoginPage.propTypes = {
    setToken: PropTypes.func.isRequired
  }

export default LoginPage
