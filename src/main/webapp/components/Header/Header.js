import logo from '../../assets/logo.png';
import './Header.css';
import { FaSearch, FaHome, FaBrain, FaFireAlt, FaComments , FaBell, FaUserCircle, FaCaretDown } from 'react-icons/fa';
import { Link } from 'react-router-dom';


const Header = () => {
    return (
        <div className="headerContainer">
            <img className="logo" src={logo} alt="Website Logo"/>

            <div className="search">
                <FaSearch className="searchIcon" />
                <input className="search-input" placeholder="Search for something..."></input>
            </div>

            <ul className="navList">
                <li className="navItem">
                    <Link to="/">
                        <FaHome className="navIcon" />
                        home
                    </Link>
                </li>
                <li className="navItem">
                    <Link to="/discover">
                        <FaBrain className="navIcon" />
                        discover
                    </Link>
                </li>
                <li className="navItem">
                    <Link to="/projects">
                        <FaFireAlt className="navIcon" />
                        projects
                    </Link>
                </li>
                <li className="navItem">
                    <Link to="/chat">
                        <FaComments className="navIcon" />
                        chat
                    </Link>
                </li>
                <li className="navItem">
                    <Link to="/alerts">
                        <FaBell className="navIcon" />
                        alerts
                    </Link>    
                </li>
                <li className="navItem navProfile">
                    <Link to="/profile">
                        <FaUserCircle className="navIcon navProfileIcon" /> 
                    </Link>
                    Yassir
                    <FaCaretDown />
                </li>
            </ul>
        </div>
    )
}

export default Header
