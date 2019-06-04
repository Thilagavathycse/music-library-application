select * from SONG_LIST
select * from artist

select songname from SONG_LIST
S join artist a on a.artistid=s.artistid WHERE a.artistid=1001  
alter table COUNRTY ADD 
foreign key(countryid) references country(countryid) 

);
CREATE TABLE music_director
(
MDID varchar(255) primary key,
MDname varchar(255)
)