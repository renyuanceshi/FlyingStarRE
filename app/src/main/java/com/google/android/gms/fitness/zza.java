package com.google.android.gms.fitness;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class zza {
    public static Scope zza(Scope scope) {
        return scope.equals(new Scope(Scopes.FITNESS_ACTIVITY_READ)) ? new Scope(Scopes.FITNESS_ACTIVITY_READ_WRITE) : scope.equals(new Scope(Scopes.FITNESS_LOCATION_READ)) ? new Scope(Scopes.FITNESS_LOCATION_READ_WRITE) : scope.equals(new Scope(Scopes.FITNESS_BODY_READ)) ? new Scope(Scopes.FITNESS_BODY_READ_WRITE) : scope.equals(new Scope(Scopes.FITNESS_NUTRITION_READ)) ? new Scope(Scopes.FITNESS_NUTRITION_READ_WRITE) : scope;
    }

    public static Set<Scope> zze(Collection<Scope> collection) {
        HashSet hashSet = new HashSet(collection.size());
        for (Scope next : collection) {
            Scope zza = zza(next);
            if (zza.equals(next) || !collection.contains(zza)) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }
}
