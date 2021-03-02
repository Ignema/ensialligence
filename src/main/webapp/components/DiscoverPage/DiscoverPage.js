import './DiscoverPage.css';
import { useState, useEffect } from 'react';

const DiscoverPage = () => {

    const [images, setImages] = useState([])

    useEffect(()=>{
        fetch("https://images-api.nasa.gov/search?q=galaxies").then((res) => res.json()).catch(err => console.log(err)).then((json)=>{
            setImages(json.collection.items.map((item, index) => item.links.map((link, index2) => ({"id": index + index2, "title": item.data[0].title, "link": link.href}))).flat())
        }).catch(err => console.log(err))
    }, [])

    return (
        <div className="discoverPageContainer">
            {images.filter(image => !["vtt", "srt"].includes(image.link.substring(image.link.length - 3, image.link.length))).map(image => <div key={image.id} className="discoverImageContainer" onClick={() => window.open("https://www.google.com/search?q=" + image.title, '_blank')}><img className="discoverImage" src={image.link} alt="Star fetched from Nasa's API" /><div className="discoverImageOverlay"><div className="discoverImageCaption">{image.title}</div></div></div> )}
        </div>
    )
}

export default DiscoverPage
