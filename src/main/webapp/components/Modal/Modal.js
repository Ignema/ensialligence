import React from 'react'
import './Modal.css'
import { FaTimesCircle } from 'react-icons/fa'
import { useState } from 'react'

const Modal = ({modal, setModal, link, user}) => {

    const [button, setButton] = useState()

    if(!modal){
        return null;
    }

    return (
        <div className="modalContainer" style={{backgroundColor: user?"rgb(51, 50, 50)":"rgb(241, 237, 237)"}}>
            <FaTimesCircle className="modalClose" style={{color: user?"rgb(241, 237, 237)":"rgb(51, 50, 50)"}} onClick={() => setModal(false)} />
            {link && <iframe className="modalView" title="modalView" src={link} frameBorder="0"/>}
            {user && <div className="profilePageContainer">
            <div className="profilePictureContainer">
                <img className="profilePagePicture" src="https://images.unsplash.com/photo-1529665253569-6d01c0eaf7b6" alt="Profile Pic" />
                <button className="profilePageButton" onClick={()=>setButton("true")} disabled={button}>{button ? "Friend Request Sent" : "Add Friend"}</button>
            </div>
            <div className="profilePageDetailsContainer">
                <div className="profilePageDetails" style={{color: "Black"}}>
                    <p><span>Firstname: </span>Yassir</p><hr/>
                    <p><span>Lastname: </span>Douslimi</p><hr/>
                    <p><span>Age: </span>21</p><hr/>
                    <p><span>City: </span>Kenitra</p><hr/>
                    <p><span>Posts: </span>30</p><hr/>
                    <p><span>Interested: </span>Software Engineering</p>
                    <p>Ensialligence</p>
                </div>
            </div>
            </div>}
        </div>
        
    )
}

export default Modal
