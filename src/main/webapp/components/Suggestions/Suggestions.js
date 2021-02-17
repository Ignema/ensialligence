import './Suggestions.css';
import { FaUser, FaUserTie, FaChalkboardTeacher, FaUserMd } from 'react-icons/fa';

const Suggestions = () => {
    return (
        <div className="suggestionsContainer">
            <p>Connect with more people</p>
            <ul>
                <li>
                    <FaUser className="suggestionsIcon" />
                    <p>Houda</p>
                </li>
                <li>
                    <FaUserTie className="suggestionsIcon" />
                    <p>Mohammed</p>
                </li>
                <li>
                    <FaChalkboardTeacher className="suggestionsIcon" />
                    <p>Hiba</p>
                </li>
                <li>
                    <FaUserMd className="suggestionsIcon" />
                    <p>Dr. Ali</p>
                </li>
            </ul>
        </div>
    )
}

export default Suggestions
