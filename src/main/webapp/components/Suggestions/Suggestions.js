import './Suggestions.css';
import { FaUser, FaUserTie, FaChalkboardTeacher, FaUserMd } from 'react-icons/fa';

const Suggestions = ({showModal, setUser}) => {
    return (
        <div className="suggestionsContainer">
            <p>Connect with more people</p>
            <ul>
                <li onClick={() => {
                        setUser("Yassir")
                        showModal()}}>
                    <FaUser className="suggestionsIcon" />
                    <p>Houda</p>
                </li>
                <li onClick={() => {
                        setUser("Yassir")
                        showModal()}}>
                    <FaUserTie className="suggestionsIcon" />
                    <p>Mohammed</p>
                </li>
                <li onClick={() => {
                        setUser("Yassir")
                        showModal()}}>
                    <FaChalkboardTeacher className="suggestionsIcon" />
                    <p>Hiba</p>
                </li>
                <li onClick={() => {
                        setUser("Yassir")
                        showModal()}}>
                    <FaUserMd className="suggestionsIcon" />
                    <p>Dr. Ali</p>
                </li>
            </ul>
        </div>
    )
}

export default Suggestions
