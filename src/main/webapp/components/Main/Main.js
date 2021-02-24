import Shortcuts from "../Shortcuts/Shortcuts"
import Scrollview from "../Scrollview/Scrollview"
import SidePanel from "../SidePanel/SidePanel"
import Modal from "../Modal/Modal"
import './Main.css';
import { useState } from "react"

const Main = () => {

    const [modal, setModal] = useState(false)
    const [link, setLink] = useState()
    const [user, setUser] = useState()

    function showModal() {
        setModal(!modal);
    }

    return (
        <>
            <div className="mainContainer" style={{opacity: modal ? 0.06 : 1}}>
                <Shortcuts showModal={showModal} setLink={setLink}/>
                <Scrollview />
                <SidePanel showModal={showModal} setUser={setUser}/>
            </div>
            <Modal modal={modal} setModal={setModal} link={link} user={user} />
        </>
    )
}

export default Main
