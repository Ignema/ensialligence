import React from 'react'
import './Dropdown.css'
import { useRef, useEffect } from 'react'

const Dropdown = ({items, width, space, toggleDropdown, type}) => {

    const ref = useRef(null);

    useEffect(() => {

        function handleClickOutside(event) {
            if (ref.current && !ref.current.contains(event.target)) {
                toggleDropdown(false)
            }
        }
        document.addEventListener("mousedown", handleClickOutside);
        return () => {
            document.removeEventListener("mousedown", handleClickOutside);
        };
    }, [toggleDropdown]);
  
    function DropdownItem({title, icon, handler}) {
        let styles = {
            width: "30px",
            height: "30px"
        }

        return (
        <span className="dropdownItem" onClick={handler ? ()=>handler() : ()=>{}}>
            <span className="dropdownItemIcon" style={icon && styles}>{icon}</span>
            {title}
        </span>
        );
    }

    let styles = {
        width: width,
        transform: "translateX(" + space + ")"
    }

    return (
      <div className="dropdownContainer" style={styles} ref={ref}>
          <div className="dropdownList">
            {type !== "search" ? items.map(item => <DropdownItem key={item.id} title={item.title} icon={item.icon} handler={item.handler} />) : items.map(item => <DropdownItem key={item.id} title={item.name} handler={item.handler} />)}
          </div>
      </div>
    );
  }

export default Dropdown
