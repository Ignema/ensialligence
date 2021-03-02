import './Ad.css';
// import { FaAd } from 'react-icons/fa';

const Ad = () => {

    const adLink = "https://mk0adespressoj4m2p68.kinstacdn.com/wp-content/uploads/2020/12/Talkspace-schedule.mp4?_=2";

    return (
        <div className="adContainer" onClick={()=>window.open(adLink, '_blank')}>
            {/* <FaAd className="adIcon" />
            <p>advertisement</p> */}
            <video width="150%" autoPlay muted loop>
                <source src={adLink}></source>
            </video>
        </div>
    )
}
export default Ad
