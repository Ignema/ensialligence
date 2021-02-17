import './LoginPage.css';
import { FaGoogle, FaFacebook, FaGithub, FaCube } from 'react-icons/fa';

const LoginPage = () => {
    return (
        <div className="loginContainer">
            <div className="loginInfo">
                <div className="loginTitle">
                    <h1>Ensialligence</h1>
                    <h2>Learn More</h2>
                    <p>Welcome  back! Please login to your account.</p>
                </div>
                <form className="loginForm">
                    <label className="loginEmailLabel" for="email">Email Address</label>
                    <input className="loginEmailInput" type="email" placeholder="Type your email..." name="email"></input>
                    <label className="loginPasswordLabel" for="password">Password</label>
                    <input className="loginPasswordInput" type="password" placeholder="Type your password..." name="password"></input>
                    <div className="loginMeta">
                        <div className="loginMetaCheck">
                            <input type="checkbox"></input>
                            <p>Remember Me</p>
                        </div>
                        <p>Forgot Password?</p>
                    </div>
                    <div className="loginBtns">
                        <input className="loginBtn loginSubmit" type='submit' value="Login"></input>
                        <input className="loginBtn loginSign" type='button' value="Sign Up"></input>
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

export default LoginPage
