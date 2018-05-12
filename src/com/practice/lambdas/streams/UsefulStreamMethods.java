package com.practice.lambdas.streams;

import com.practice.lambdas.refactor.Albums;
import com.practice.lambdas.refactor.Artist;
import com.practice.lambdas.refactor.Track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsefulStreamMethods {

    public static void main(String args[])
    {
        List<Integer> numbers = Arrays.asList( new Integer[]{1,2,3,5,6,7,8,12,15,17});
        System.out.println(addUp(numbers.stream()));
        Artist artist1 = new Artist("Shaan","India",1);
        Artist artist2 = new Artist("Brad Pitt","USA",1);
        Artist artist3 = new Artist("Scarlett Johanssen","Austrilia",1);
        List<Artist> listArtist = Arrays.asList(new Artist[]{artist1,artist2,artist3});
        List<String> artistWithNationality = getArtistWithNationlity(listArtist);
        artistWithNationality.forEach(System.out::println);
        List<Albums> albumsList = getAlbumsList();
        List<Albums> albumsWithMaxThreeTracks = getAlbumsWithAtmostThreeTracks(albumsList);
        albumsWithMaxThreeTracks.forEach(albums -> System.out.println(albums.getAlbumName()));
        System.out.println(countMembersForArtist(listArtist));
        countLowercaseInString("PUNEEt");
    }

    private static int addUp(Stream<Integer> numbers)
    {
        return numbers.reduce(0,(a,b)->a+b);
    }

    private static List<String> getArtistWithNationlity(List<Artist> artistList)
    {
        return artistList.stream().
                map(artist -> artist.getName()+" - "+artist.getNationality()).
                collect(Collectors.toList());
    }

    private static List<Albums> getAlbumsList()
    {
        Track t1 = new Track("mein hoon na", 120);
        Track t2 = new Track("jo jeeta wohi sikandar", 60);
        Track t3 = new Track("ye jo desh hai", 55);
        Track t4 = new Track("test", 30);
        List<Track> list1 = new ArrayList<>();
        list1.add(t1);
        list1.add(t2);
        list1.add(t3);
        list1.add(t4);
        Albums a1 = new Albums("album1", list1);
        Track t5 = new Track("test again", 50);
        Track t6 = new Track("test again & again", 155);
        List<Track> list2 = new ArrayList<>();
        list2.add(t5);
        list2.add(t6);
        Albums a2 = new Albums("album2", list2);
        Track t7 = new Track("want this in that way", 50);
        Track t8 = new Track("linkin park", 155);
        List<Track> list3 = new ArrayList<>();
        list3.add(t7);
        list3.add(t8);
        Albums a3 = new Albums("album3", list3);
        List<Albums> listAlbums = new ArrayList<>();
        listAlbums.add(a1);
        listAlbums.add(a2);
        listAlbums.add(a3);
        return listAlbums;
    }

    private static List<Albums> getAlbumsWithAtmostThreeTracks(List<Albums> albumsList)
    {
        return albumsList.stream().
                filter(albums -> albums.getTracks().size()<=3).
                collect(Collectors.toList());
    }

    private static int countMembersForArtist(List<Artist> artistList)
    {
        /*int totalMembers = 0; //imperative way
        for (Artist artist : artists)
        {
            Stream<Artist> members = artist.getMembers();
            totalMembers += members.count();
        }*/
        return artistList.stream().
                map(artist -> artist.getMembers()).
                reduce(0,(a,b)->a+b);
    }

    private static void countLowercaseInString(String str)
    {
        System.out.println(str.chars().mapToObj(value -> (char)value).filter(val -> Character.valueOf(val).isLowerCase(val)).count());
    }

}
