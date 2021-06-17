create table JAVI_Library (
	uuid_ VARCHAR(75) null,
	ISBN LONG not null primary key,
	title VARCHAR(75) null,
	writer VARCHAR(75) null,
	publication DATE null
);