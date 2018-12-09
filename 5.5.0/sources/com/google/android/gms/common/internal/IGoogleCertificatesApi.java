package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.GoogleCertificatesQuery;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;

public interface IGoogleCertificatesApi extends IInterface {

    public static abstract class Stub extends zzb implements IGoogleCertificatesApi {

        public static class Proxy extends zza implements IGoogleCertificatesApi {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
            }

            public IObjectWrapper getGoogleCertificates() {
                Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken());
                IObjectWrapper asInterface = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            public IObjectWrapper getGoogleReleaseCertificates() {
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
                IObjectWrapper asInterface = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            public boolean isGoogleOrPlatformSigned(GoogleCertificatesQuery googleCertificatesQuery, IObjectWrapper iObjectWrapper) {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) googleCertificatesQuery);
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
                obtainAndWriteInterfaceToken = transactAndReadException(5, obtainAndWriteInterfaceToken);
                boolean zza = zzc.zza(obtainAndWriteInterfaceToken);
                obtainAndWriteInterfaceToken.recycle();
                return zza;
            }

            public boolean isGoogleReleaseSigned(String str, IObjectWrapper iObjectWrapper) {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeString(str);
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
                obtainAndWriteInterfaceToken = transactAndReadException(3, obtainAndWriteInterfaceToken);
                boolean zza = zzc.zza(obtainAndWriteInterfaceToken);
                obtainAndWriteInterfaceToken.recycle();
                return zza;
            }

            public boolean isGoogleSigned(String str, IObjectWrapper iObjectWrapper) {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeString(str);
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
                obtainAndWriteInterfaceToken = transactAndReadException(4, obtainAndWriteInterfaceToken);
                boolean zza = zzc.zza(obtainAndWriteInterfaceToken);
                obtainAndWriteInterfaceToken.recycle();
                return zza;
            }
        }

        public Stub() {
            super("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        }

        public static IGoogleCertificatesApi asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
            return queryLocalInterface instanceof IGoogleCertificatesApi ? (IGoogleCertificatesApi) queryLocalInterface : new Proxy(iBinder);
        }

        protected boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
            IInterface googleCertificates;
            boolean isGoogleReleaseSigned;
            switch (i) {
                case 1:
                    googleCertificates = getGoogleCertificates();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, googleCertificates);
                    break;
                case 2:
                    googleCertificates = getGoogleReleaseCertificates();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, googleCertificates);
                    break;
                case 3:
                    isGoogleReleaseSigned = isGoogleReleaseSigned(parcel.readString(), com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    zzc.zza(parcel2, isGoogleReleaseSigned);
                    break;
                case 4:
                    isGoogleReleaseSigned = isGoogleSigned(parcel.readString(), com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    zzc.zza(parcel2, isGoogleReleaseSigned);
                    break;
                case 5:
                    isGoogleReleaseSigned = isGoogleOrPlatformSigned((GoogleCertificatesQuery) zzc.zza(parcel, GoogleCertificatesQuery.CREATOR), com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    zzc.zza(parcel2, isGoogleReleaseSigned);
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    IObjectWrapper getGoogleCertificates();

    IObjectWrapper getGoogleReleaseCertificates();

    boolean isGoogleOrPlatformSigned(GoogleCertificatesQuery googleCertificatesQuery, IObjectWrapper iObjectWrapper);

    boolean isGoogleReleaseSigned(String str, IObjectWrapper iObjectWrapper);

    boolean isGoogleSigned(String str, IObjectWrapper iObjectWrapper);
}
