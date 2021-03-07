import './Message.css';

const Message = ({message, position}) => {
    return (
        <div style={(position==='right')?{marginLeft: 'auto', marginRight: '3rem'}:{marginLeft: '3rem', marginRight: 'auto'}} className="messageContainer">
            <div style={(position==='right')?{right: '-45px', borderLeft: '30px solid #C4C4C4', borderRight: '30px solid transparent'}:{left: '-45px', borderLeft: '30px solid transparent', borderRight: '30px solid #C4C4C4'}} className="messageNotch"></div>
            <p className="messageContent">{ message.body !== null ? message.body : "Découvrez avec Meriem Belkhayat, la technologie UltraCare de Arthur Martin. La machine à laver PerfectCare 800 de Arthur Martin avec système UltraMix, active le pouvoir nettoyant de la lessive et de l'adoucissant en les mélangeant à l'eau, avant de pulvériser le mix à l'aide de la douchette DirectSpray dans le tambour afin d'atteindre tous les angles de la charge de vêtements dans le tambour. Résultat ? Vos vêtements sont doux et propres même avec des cycles à basse température ! 👌"}</p>
            <p className="messageTime">{message.date}</p>
        </div>
    )
}

export default Message
