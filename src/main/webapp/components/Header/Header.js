import logo from '../../assets/logo.png';
import './Header.css';
import { FaSearch, FaHome, FaBrain, FaFireAlt, FaComments , FaBell, FaUserCircle, FaCaretDown } from 'react-icons/fa';
import { Link } from 'react-router-dom';
import { useState } from 'react';
import Dropdown from '../Dropdown/Dropdown';

const filterItems = (items, query) => {
    if (!query) {
        return items;
    }

    return items.filter((item) => {
        const title = item.name.toLowerCase();
        return title.includes(query);
    });
};


const Header = ({setToken}) => {
    const [openAlerts, setOpenAlerts] = useState(false);
    const [openSettings, setOpenSettings] = useState(false);
    const [openSearch, setOpenSearch] = useState(false);

    const alerts = [
        {id: 0, title: "New Friend: Mohammed Eddaghal", icon: "❤"},
        {id: 1, title: "New post by your friend Houda", icon: "🔥"}, 
        {id: 2, title: "Don't miss the latest article", icon: "✨"}
    ];

    const settings = [
        {id: 0, title: "My Profile"},
        {id: 1, title: "Privacy"}, 
        {id: 2, title: "About"}, 
        {id: 3, title: "Disconnect", handler: () => {
            localStorage.removeItem("token")
            window.location.reload()
        }}
    ];

    const posts = [
        { id: '1', name: 'This first post is about React' },
        { id: '2', name: 'This next post is about Preact' },
        { id: '3', name: 'We have yet another React post!' },
        { id: '4', name: 'This is the fourth and final post' },
    ];

    const { search } = window.location;
    const query = new URLSearchParams(search).get('s');
    const [searchQuery, setSearchQuery] = useState(query || '');
    const filteredPosts = filterItems(posts, searchQuery);

    return (
        <div className="headerContainer">
            <Link to="/">
                <img className="logo" src={logo} alt="Website Logo"/>
            </Link>

            <div className="search" onClick={() => setOpenSearch(!openSearch)}>
                <FaSearch className="searchIcon" />
                <form action="/" method="get" className="search-input" >
                    <input value={searchQuery} onInput={e => setSearchQuery(e.target.value)} type="text" name="search" placeholder="Search for something..."></input>
                    <input type="submit" hidden/>
                </form>
                {searchQuery && openSearch && <Dropdown items={filteredPosts} width="500px" space="-20%" type="search" toggleDropdown={setOpenSearch}/>}
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
                        stories
                    </Link>
                </li>
                <li className="navItem">
                    <Link to="/chat">
                        <FaComments className="navIcon" />
                        chat
                    </Link>
                </li>
                <li className="navItem navDrop" onClick={() => setOpenAlerts(!openAlerts)}>
                    <FaBell className="navIcon" />
                    alerts 
                    {openAlerts && <Dropdown items={alerts} width="500px" space="-20%" toggleDropdown={setOpenAlerts}/>} 
                </li>
                <li className="navItem navProfile">
                    <Link to="/profile">
                        <FaUserCircle className="navIcon navProfileIcon" /> 
                    </Link>
                    <div className="navCaretDrop" onClick={() => setOpenSettings(!openSettings)}>
                        Yassir
                        <FaCaretDown />
                    {openSettings && <Dropdown items={settings} width="200px" space="-65%" toggleDropdown={setOpenSettings}/>} 
                    </div>     
                </li>
            </ul>
        </div>
    )
}

export default Header
