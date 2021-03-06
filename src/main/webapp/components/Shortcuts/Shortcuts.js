import './Shortcuts.css'
import { FaUserAstronaut, FaAtom, FaGlobeEurope, FaLinux, FaChartPie, FaApple } from 'react-icons/fa';

const Shortcuts = ({showModal, setLink}) => {
    return (
        <div className="outerShortcuts">
            <div className="innerShortcuts">
                <p className="shortTitle">Shortcuts</p>
            
                <ul className="shortList">
                    <li className="shortItem" onClick={() => {
                        setLink("https://en.wikipedia.org/wiki/Astronomy?printable=yes")
                        showModal()}}>
                        <FaUserAstronaut />
                    </li>
                    <li className="shortItem" onClick={() => {
                        setLink("https://en.wikipedia.org/wiki/Chemistry?printable=yes")
                        showModal()}}>
                        <FaAtom />
                    </li>
                    <li className="shortItem" onClick={() => {
                        setLink("https://en.wikipedia.org/wiki/Geography?printable=yes")
                        showModal()}}>
                        <FaGlobeEurope />
                    </li>
                    <li className="shortItem" onClick={() => {
                        setLink("https://en.wikipedia.org/wiki/Linux?printable=yes")
                        showModal()}}>
                        <FaLinux />
                    </li>
                    <li className="shortItem" onClick={() => {
                        setLink("https://en.wikipedia.org/wiki/Economics?printable=yes")
                        showModal()}}>
                        <FaChartPie />                        
                    </li>
                    <li className="shortItem" onClick={() => {
                        setLink("https://en.wikipedia.org/wiki/Apple_Inc.?printable=yes")
                        showModal()}}>
                        <FaApple />
                    </li>
                </ul>
            </div>
        </div>
    )
}

export default Shortcuts
