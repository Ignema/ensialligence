import './Ad.css';
import { FaAd } from 'react-icons/fa';

const Ad = () => {
    return (
        <div className="adContainer">
            <FaAd className="adIcon" />
            <p>advertisement</p>
        </div>
    )
}

export default Ad
