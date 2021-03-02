import Ad from "../Ad/Ad"
import Suggestions from "../Suggestions/Suggestions"
// import Chat from "../Chat/Chat"
import './SidePanel.css';

const SidePanel = ({showModal, setUser}) => {
    return (
        <div className="outerSidePanel">
            <div className="innerSidePanel">
                <Ad />
                <Suggestions showModal={showModal} setUser={setUser} />
                {/* <Chat /> */}
            </div>
        </div>
    )
}

export default SidePanel
