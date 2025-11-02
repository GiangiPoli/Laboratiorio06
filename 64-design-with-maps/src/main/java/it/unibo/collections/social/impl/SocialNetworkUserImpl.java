/**
 *
 */

package it.unibo.collections.social.impl;

import it.unibo.collections.social.api.SocialNetworkUser;
import it.unibo.collections.social.api.User;

//import java.util.ArrayList;
import java.util.Collection;
//import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
//import java.util.Set;

/**
 * This will be an implementation of
 * {@link SocialNetworkUser}:
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 *
 * @param <U>
 *            Specific {@link User} type
 */
public final class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    //Class Fields

    /*
     * Creaiting the map that connect the followed person ( KEY ) 
     * to the group ( VALUE ).
     */
    private Map<String, HashSet<U>> followedUserMap = new HashMap<>();



    //Class Constructors

    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user,  userAge);
    }

    public SocialNetworkUserImpl(final String name, final String surname, final String user) {
        super(name, surname, user, -1);
    }


    //Class Method

    /*
     * [IMPORTANTE] Lo scrivo in italiano, in quanto voglio essere chiaro:
     * Avendo implementato una mappa con una Stringa come key, e
     * un HashSet<U> come insieme di valori, uso la funzione get(nomeKey)
     * che mi restituisce il mio Set di valori associato a tale chiave su 
     * cui posso usare i metodi dedicati ai set. Quindi non usero, ad esempio, 
     * il metodo put delle mappe
     */

    @Override
    public boolean addFollowedUser(final String circle, final U user) {
    
        /*
        *If the specified group (circle) is absent in the map
        *i create it, associating the SET of user to it
        */
        followedUserMap.putIfAbsent(circle, new HashSet<U>());

        return followedUserMap.get(circle).add(user);

    }

    /**
     *
     * [NOTE] If no group with groupName exists yet, this implementation must
     * return an empty Collection.
     */
    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {

        if( followedUserMap.containsKey(groupName) ) {
            return new HashSet<>(followedUserMap.get(groupName));
        }

        return new HashSet<U>();
    }

    @Override
    public List<U> getFollowedUsers() {
        
        final List<U> allFollowedUser = new LinkedList<>();

        /*
         * With this kind of foreach i have real fast acces to
         * all the keys in the map
         */
        for (String group : followedUserMap.keySet()) {
            allFollowedUser.addAll(followedUserMap.get(group));
        }

        return allFollowedUser;
    }
}
