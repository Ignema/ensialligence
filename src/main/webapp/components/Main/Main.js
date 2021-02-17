import Shortcuts from "../Shortcuts/Shortcuts"
import Scrollview from "../Scrollview/Scrollview"
import SidePanel from "../SidePanel/SidePanel"
import './Main.css';

const Main = () => {
    return (
        <div className="mainContainer">
            <Shortcuts />
            <Scrollview />
            <SidePanel />
        </div>
    )
}

export default Main
