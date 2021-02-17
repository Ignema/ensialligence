import './Shortcuts.css'
import { FaUserAstronaut, FaAtom, FaGlobeEurope, FaLinux, FaChartPie, FaChevronCircleDown } from 'react-icons/fa';

const Shortcuts = () => {
    return (
        <div className="outerShortcuts">
            <div className="innerShortcuts">
                <p className="shortTitle">Shortcuts</p>
            
                <ul className="shortList">
                    <li className="shortItem">
                        <FaUserAstronaut />
                    </li>
                    <li className="shortItem">
                        <FaAtom />
                    </li>
                    <li className="shortItem">
                        <FaGlobeEurope />
                    </li>
                    <li className="shortItem">
                        <FaLinux />
                    </li>
                    <li className="shortItem">
                        <FaChartPie />                        
                    </li>
                    <li className="shortItem">
                        <FaChevronCircleDown />
                    </li>
                </ul>
            </div>
        </div>
    )
}

export default Shortcuts
