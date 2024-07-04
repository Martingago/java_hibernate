package com.applicacion_hibernate.dto;

import com.applicacion_hibernate.entidades.blog.Post;
import com.applicacion_hibernate.entidades.blog.PostDetails;
import com.applicacion_hibernate.entidades.blog.Tag;

import java.util.Set;

public class Publicacion {
    private Post post;
    private PostDetails postDetails;
    private Set<Tag> tagSet;

    public Publicacion(Post post, PostDetails postDetails, Set<Tag> tagSet) {
        this.post = post;
        this.postDetails = postDetails;
        this.tagSet = tagSet;
    }

    public Post getPost() {
        return post;
    }

    public PostDetails getPostDetails() {
        return postDetails;
    }

    public Set<Tag> getTagSet() {
        return tagSet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nDatos de la publicación: \n").append(post.toString()).append("\n");;

        if(postDetails != null){
            sb.append(postDetails.toString()).append("\n");
        }else{
            sb.append("Este Post no tiene PostDetails").append("\n");
        }
        if (tagSet != null && !tagSet.isEmpty()) {
            sb.append("Etiquetas: ");
            for (Tag tag : tagSet) {
                sb.append(tag.toString()).append(", ");
            }
            // Eliminar la última coma y espacio
            sb.setLength(sb.length() - 2);
            sb.append("\n");
        } else {
            sb.append("Este post no tiene tags incluidas\n");
        }
        return sb.toString();
    }

}

