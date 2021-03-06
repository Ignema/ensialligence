import './ProfilePage.css';
import PostList from "../PostList/PostList"

const ProfilePage = () => {

    let posts = []
    for(let i = 0; i < 30; i++){
        posts.push({
            titre: "title",
            categorie: "article", 
            nbjaimeart: 20,
            video: "Post " + (i+1),
            comments: [{
                owner: localStorage.getItem('username'), 
                body: "Random Comment", 
                nbJaimeCom: 33
            }]
        })
    }

    return (
        <div className="profilePageContainer">
            <div className="profilePagePictureContainer">
                <img className="profilePagePicture" src="https://images.unsplash.com/photo-1529665253569-6d01c0eaf7b6" alt="Profile Pic" />
            </div>
            <div className="profilePageHistory">
                <h1>Post History</h1>
                <PostList posts={posts} />
            </div>
            <div className="profilePageDetailsContainer">
                <div className="profilePageDetails">
                    <p><span>Username: </span>{localStorage.getItem('username')}</p><hr/>
                    <p><span>Sexe: </span>male</p><hr/>
                    <p><span>Age: </span>21</p><hr/>
                    <p><span>City: </span>Kenitra</p><hr/>
                    <p><span>Posts: </span>30</p><hr/>
                    <p><span>Interested: </span>Software Engineering</p>
                    <p>Ensialligence</p>
                </div>
            </div>
        </div>
    )
}

export default ProfilePage
