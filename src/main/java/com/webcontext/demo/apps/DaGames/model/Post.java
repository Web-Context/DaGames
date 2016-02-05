/**
 * file: Post.java
 * date: 5 févr. 2016
 *
 * GEHC DoseWatch
 *
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 *
 */

package com.webcontext.demo.apps.DaGames.model;

import java.util.Date;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * Post entity to manage content.
 * 
 * @author Frédéric Delorme
 *
 */
public class Post {

	@Id
	private String id;

	
	@NotNull
	private String type;
	
	@Size(min = 2, max = 100)
	@NotNull
	@Indexed(unique=true)
	private String title;

	@Size(min = 0, max = 400)
	private String header;

	@Size(min = 0, max = 4000)
	@NotNull
	private String content;

	private String author;
	
	private String createdBy;

	private Date createdAt;

	private PublicationState status;
	
	private Date publicationAt;

	private Map<String, Object> metadata;

	/**
	 * Default constructor
	 */
	public Post() {

	}

	/**
	 * Parameterized constructor.
	 * 
	 * @param id
	 * @param title
	 * @param header
	 * @param content
	 * @param author
	 * @param createdAt
	 * @param status
	 * @param metadata
	 */
	public Post(String id,String type, String title, String header, String content, String author, Date createdAt, String createdBy, PublicationState status, Date publicationAt,
			Map<String, Object> metadata) {
		super();
		this.id = id;
		this.type = type;
		this.title = title;
		this.header = header;
		this.content = content;
		this.author = author;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		
		this.status = status;
		this.publicationAt = publicationAt;
		this.metadata = metadata;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId( String id ) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle( String title ) {
		this.title = title;
	}

	/**
	 * @return the header
	 */
	public String getHeader() {
		return header;
	}

	/**
	 * @param header
	 *            the header to set
	 */
	public void setHeader( String header ) {
		this.header = header;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent( String content ) {
		this.content = content;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor( String author ) {
		this.author = author;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt
	 *            the createdAt to set
	 */
	public void setCreatedAt( Date createdAt ) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the status
	 */
	public PublicationState getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus( PublicationState status ) {
		this.status = status;
	}

	public Date getPublicationAt() {
		return publicationAt;
	}

	public void setPublicationAt(Date publicationAt) {
		this.publicationAt = publicationAt;
	}

	/**
	 * @return the metadata
	 */
	public Map<String, Object> getMetadata() {
		return metadata;
	}

	/**
	 * @param metadata
	 *            the metadata to set
	 */
	public void setMetadata( Map<String, Object> metadata ) {
		this.metadata = metadata;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((header == null) ? 0 : header.hashCode());
		result = prime * result + ((metadata == null) ? 0 : metadata.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals( Object obj ) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (header == null) {
			if (other.header != null)
				return false;
		} else if (!header.equals(other.header))
			return false;
		if (metadata == null) {
			if (other.metadata != null)
				return false;
		} else if (!metadata.equals(other.metadata))
			return false;
		if (status != other.status)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Post [")
		.append("id=").append(id)
		.append(", type=").append(type)
		.append(", title=").append(title)
		.append(", header=").append(header)
		.append(", content=").append(content)
		.append(", author=").append(author)
		.append(", createdAt=").append(createdAt)
		.append(", createdBy=").append(createdBy)
		.append(", status=").append(status)
		.append(", publicationAt=").append(publicationAt)
		.append(", metadata=").append(metadata)
		.append("]");
		return builder.toString();
	}

}
