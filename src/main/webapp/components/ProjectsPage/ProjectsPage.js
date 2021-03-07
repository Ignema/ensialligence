import './ProjectsPage.css';
import { useState, useEffect } from 'react';

const ProjectsPage = () => {

    const [stories, setStories] = useState([])

    useEffect(()=>{
        fetch("https://www.reddit.com/r/programming.json?limit=100").then((res) => res.json()).catch(err => console.log(err)).then((json)=>{
            setStories(json.data.children.map((child, index) => ({"id": index, "title": child.data.title, "link": child.data.url})))
        }).catch(err => console.log(err))
    }, [])

    return (
        <div className="projectsPageContainer">
            {stories.map(story => <div key={story.id}><p className="projectsPageTitle" onClick={() => window.open(story.link, '_blank')}>{story.title}</p><br/><hr/><br/></div>)}
        </div>
    )
}

export default ProjectsPage
