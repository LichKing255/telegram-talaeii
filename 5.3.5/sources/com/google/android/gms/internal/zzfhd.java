package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

final class zzfhd extends zzfhb {
    private final byte[] buffer;
    private final boolean immutable;
    private int limit;
    private int pos;
    private int zzpoh;
    private int zzpoi;
    private int zzpoj;
    private int zzpok;

    private zzfhd(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzpok = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i + i2;
        this.pos = i;
        this.zzpoi = this.pos;
        this.immutable = z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zzcyr() throws java.io.IOException {
        /*
        r10 = this;
        r8 = 0;
        r0 = r10.pos;
        r1 = r10.limit;
        if (r1 == r0) goto L_0x00b4;
    L_0x0008:
        r4 = r10.buffer;
        r1 = r0 + 1;
        r0 = r4[r0];
        if (r0 < 0) goto L_0x0014;
    L_0x0010:
        r10.pos = r1;
        r0 = (long) r0;
    L_0x0013:
        return r0;
    L_0x0014:
        r2 = r10.limit;
        r2 = r2 - r1;
        r3 = 9;
        if (r2 < r3) goto L_0x00b4;
    L_0x001b:
        r2 = r1 + 1;
        r1 = r4[r1];
        r1 = r1 << 7;
        r0 = r0 ^ r1;
        if (r0 >= 0) goto L_0x002a;
    L_0x0024:
        r0 = r0 ^ -128;
        r0 = (long) r0;
    L_0x0027:
        r10.pos = r2;
        goto L_0x0013;
    L_0x002a:
        r3 = r2 + 1;
        r1 = r4[r2];
        r1 = r1 << 14;
        r0 = r0 ^ r1;
        if (r0 < 0) goto L_0x0038;
    L_0x0033:
        r0 = r0 ^ 16256;
        r0 = (long) r0;
        r2 = r3;
        goto L_0x0027;
    L_0x0038:
        r2 = r3 + 1;
        r1 = r4[r3];
        r1 = r1 << 21;
        r0 = r0 ^ r1;
        if (r0 >= 0) goto L_0x0047;
    L_0x0041:
        r1 = -2080896; // 0xffffffffffe03f80 float:NaN double:NaN;
        r0 = r0 ^ r1;
        r0 = (long) r0;
        goto L_0x0027;
    L_0x0047:
        r0 = (long) r0;
        r3 = r2 + 1;
        r2 = r4[r2];
        r6 = (long) r2;
        r2 = 28;
        r6 = r6 << r2;
        r0 = r0 ^ r6;
        r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r2 < 0) goto L_0x005b;
    L_0x0055:
        r4 = 266354560; // 0xfe03f80 float:2.2112565E-29 double:1.315966377E-315;
        r0 = r0 ^ r4;
        r2 = r3;
        goto L_0x0027;
    L_0x005b:
        r2 = r3 + 1;
        r3 = r4[r3];
        r6 = (long) r3;
        r3 = 35;
        r6 = r6 << r3;
        r0 = r0 ^ r6;
        r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r3 >= 0) goto L_0x006f;
    L_0x0068:
        r4 = -34093383808; // 0xfffffff80fe03f80 float:2.2112565E-29 double:NaN;
        r0 = r0 ^ r4;
        goto L_0x0027;
    L_0x006f:
        r3 = r2 + 1;
        r2 = r4[r2];
        r6 = (long) r2;
        r2 = 42;
        r6 = r6 << r2;
        r0 = r0 ^ r6;
        r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r2 < 0) goto L_0x0084;
    L_0x007c:
        r4 = 4363953127296; // 0x3f80fe03f80 float:2.2112565E-29 double:2.1560793202584E-311;
        r0 = r0 ^ r4;
        r2 = r3;
        goto L_0x0027;
    L_0x0084:
        r2 = r3 + 1;
        r3 = r4[r3];
        r6 = (long) r3;
        r3 = 49;
        r6 = r6 << r3;
        r0 = r0 ^ r6;
        r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r3 >= 0) goto L_0x0098;
    L_0x0091:
        r4 = -558586000294016; // 0xfffe03f80fe03f80 float:2.2112565E-29 double:NaN;
        r0 = r0 ^ r4;
        goto L_0x0027;
    L_0x0098:
        r3 = r2 + 1;
        r2 = r4[r2];
        r6 = (long) r2;
        r2 = 56;
        r6 = r6 << r2;
        r0 = r0 ^ r6;
        r6 = 71499008037633920; // 0xfe03f80fe03f80 float:2.2112565E-29 double:6.838959413692434E-304;
        r0 = r0 ^ r6;
        r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r2 >= 0) goto L_0x00ba;
    L_0x00ab:
        r2 = r3 + 1;
        r3 = r4[r3];
        r4 = (long) r3;
        r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r3 >= 0) goto L_0x0027;
    L_0x00b4:
        r0 = r10.zzcyn();
        goto L_0x0013;
    L_0x00ba:
        r2 = r3;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfhd.zzcyr():long");
    }

    private final int zzcys() throws IOException {
        int i = this.pos;
        if (this.limit - i < 4) {
            throw zzfie.zzdae();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16));
    }

    private final long zzcyt() throws IOException {
        int i = this.pos;
        if (this.limit - i < 8) {
            throw zzfie.zzdae();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((((((((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8)) | ((((long) bArr[i + 2]) & 255) << 16)) | ((((long) bArr[i + 3]) & 255) << 24)) | ((((long) bArr[i + 4]) & 255) << 32)) | ((((long) bArr[i + 5]) & 255) << 40)) | ((((long) bArr[i + 6]) & 255) << 48));
    }

    private final void zzcyu() {
        this.limit += this.zzpoh;
        int i = this.limit - this.zzpoi;
        if (i > this.zzpok) {
            this.zzpoh = i - this.zzpok;
            this.limit -= this.zzpoh;
            return;
        }
        this.zzpoh = 0;
    }

    private final byte zzcyv() throws IOException {
        if (this.pos == this.limit) {
            throw zzfie.zzdae();
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzcyt());
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzcys());
    }

    public final String readString() throws IOException {
        int zzcym = zzcym();
        if (zzcym > 0 && zzcym <= this.limit - this.pos) {
            String str = new String(this.buffer, this.pos, zzcym, zzfhz.UTF_8);
            this.pos = zzcym + this.pos;
            return str;
        } else if (zzcym == 0) {
            return "";
        } else {
            if (zzcym < 0) {
                throw zzfie.zzdaf();
            }
            throw zzfie.zzdae();
        }
    }

    public final <T extends zzfhu<T, ?>> T zza(T t, zzfhm zzfhm) throws IOException {
        int zzcym = zzcym();
        if (this.zzpoc >= this.zzpod) {
            throw zzfie.zzdak();
        }
        zzcym = zzli(zzcym);
        this.zzpoc++;
        T zza = zzfhu.zza((zzfhu) t, (zzfhb) this, zzfhm);
        zzlf(0);
        this.zzpoc--;
        zzlj(zzcym);
        return zza;
    }

    public final void zza(zzfjd zzfjd, zzfhm zzfhm) throws IOException {
        int zzcym = zzcym();
        if (this.zzpoc >= this.zzpod) {
            throw zzfie.zzdak();
        }
        zzcym = zzli(zzcym);
        this.zzpoc++;
        zzfjd.zzb(this, zzfhm);
        zzlf(0);
        this.zzpoc--;
        zzlj(zzcym);
    }

    public final int zzcxx() throws IOException {
        if (zzcyp()) {
            this.zzpoj = 0;
            return 0;
        }
        this.zzpoj = zzcym();
        if ((this.zzpoj >>> 3) != 0) {
            return this.zzpoj;
        }
        throw zzfie.zzdah();
    }

    public final long zzcxy() throws IOException {
        return zzcyr();
    }

    public final long zzcxz() throws IOException {
        return zzcyr();
    }

    public final int zzcya() throws IOException {
        return zzcym();
    }

    public final long zzcyb() throws IOException {
        return zzcyt();
    }

    public final int zzcyc() throws IOException {
        return zzcys();
    }

    public final boolean zzcyd() throws IOException {
        return zzcyr() != 0;
    }

    public final String zzcye() throws IOException {
        int zzcym = zzcym();
        if (zzcym <= 0 || zzcym > this.limit - this.pos) {
            if (zzcym == 0) {
                return "";
            }
            if (zzcym <= 0) {
                throw zzfie.zzdaf();
            }
            throw zzfie.zzdae();
        } else if (zzfks.zzl(this.buffer, this.pos, this.pos + zzcym)) {
            int i = this.pos;
            this.pos += zzcym;
            return new String(this.buffer, i, zzcym, zzfhz.UTF_8);
        } else {
            throw zzfie.zzdam();
        }
    }

    public final zzfgs zzcyf() throws IOException {
        int zzcym = zzcym();
        if (zzcym > 0 && zzcym <= this.limit - this.pos) {
            zzfgs zzf = zzfgs.zzf(this.buffer, this.pos, zzcym);
            this.pos = zzcym + this.pos;
            return zzf;
        } else if (zzcym == 0) {
            return zzfgs.zzpnw;
        } else {
            byte[] copyOfRange;
            if (zzcym > 0 && zzcym <= this.limit - this.pos) {
                int i = this.pos;
                this.pos = zzcym + this.pos;
                copyOfRange = Arrays.copyOfRange(this.buffer, i, this.pos);
            } else if (zzcym > 0) {
                throw zzfie.zzdae();
            } else if (zzcym == 0) {
                copyOfRange = zzfhz.EMPTY_BYTE_ARRAY;
            } else {
                throw zzfie.zzdaf();
            }
            return zzfgs.zzba(copyOfRange);
        }
    }

    public final int zzcyg() throws IOException {
        return zzcym();
    }

    public final int zzcyh() throws IOException {
        return zzcym();
    }

    public final int zzcyi() throws IOException {
        return zzcys();
    }

    public final long zzcyj() throws IOException {
        return zzcyt();
    }

    public final int zzcyk() throws IOException {
        return zzfhb.zzll(zzcym());
    }

    public final long zzcyl() throws IOException {
        return zzfhb.zzct(zzcyr());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzcym() throws java.io.IOException {
        /*
        r5 = this;
        r0 = r5.pos;
        r1 = r5.limit;
        if (r1 == r0) goto L_0x006c;
    L_0x0006:
        r3 = r5.buffer;
        r2 = r0 + 1;
        r0 = r3[r0];
        if (r0 < 0) goto L_0x0011;
    L_0x000e:
        r5.pos = r2;
    L_0x0010:
        return r0;
    L_0x0011:
        r1 = r5.limit;
        r1 = r1 - r2;
        r4 = 9;
        if (r1 < r4) goto L_0x006c;
    L_0x0018:
        r1 = r2 + 1;
        r2 = r3[r2];
        r2 = r2 << 7;
        r0 = r0 ^ r2;
        if (r0 >= 0) goto L_0x0026;
    L_0x0021:
        r0 = r0 ^ -128;
    L_0x0023:
        r5.pos = r1;
        goto L_0x0010;
    L_0x0026:
        r2 = r1 + 1;
        r1 = r3[r1];
        r1 = r1 << 14;
        r0 = r0 ^ r1;
        if (r0 < 0) goto L_0x0033;
    L_0x002f:
        r0 = r0 ^ 16256;
        r1 = r2;
        goto L_0x0023;
    L_0x0033:
        r1 = r2 + 1;
        r2 = r3[r2];
        r2 = r2 << 21;
        r0 = r0 ^ r2;
        if (r0 >= 0) goto L_0x0041;
    L_0x003c:
        r2 = -2080896; // 0xffffffffffe03f80 float:NaN double:NaN;
        r0 = r0 ^ r2;
        goto L_0x0023;
    L_0x0041:
        r2 = r1 + 1;
        r1 = r3[r1];
        r4 = r1 << 28;
        r0 = r0 ^ r4;
        r4 = 266354560; // 0xfe03f80 float:2.2112565E-29 double:1.315966377E-315;
        r0 = r0 ^ r4;
        if (r1 >= 0) goto L_0x0072;
    L_0x004e:
        r1 = r2 + 1;
        r2 = r3[r2];
        if (r2 >= 0) goto L_0x0023;
    L_0x0054:
        r2 = r1 + 1;
        r1 = r3[r1];
        if (r1 >= 0) goto L_0x0072;
    L_0x005a:
        r1 = r2 + 1;
        r2 = r3[r2];
        if (r2 >= 0) goto L_0x0023;
    L_0x0060:
        r2 = r1 + 1;
        r1 = r3[r1];
        if (r1 >= 0) goto L_0x0072;
    L_0x0066:
        r1 = r2 + 1;
        r2 = r3[r2];
        if (r2 >= 0) goto L_0x0023;
    L_0x006c:
        r0 = r5.zzcyn();
        r0 = (int) r0;
        goto L_0x0010;
    L_0x0072:
        r1 = r2;
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfhd.zzcym():int");
    }

    final long zzcyn() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzcyv = zzcyv();
            j |= ((long) (zzcyv & 127)) << i;
            if ((zzcyv & 128) == 0) {
                return j;
            }
        }
        throw zzfie.zzdag();
    }

    public final int zzcyo() {
        return this.zzpok == Integer.MAX_VALUE ? -1 : this.zzpok - zzcyq();
    }

    public final boolean zzcyp() throws IOException {
        return this.pos == this.limit;
    }

    public final int zzcyq() {
        return this.pos - this.zzpoi;
    }

    public final void zzlf(int i) throws zzfie {
        if (this.zzpoj != i) {
            throw zzfie.zzdai();
        }
    }

    public final boolean zzlg(int i) throws IOException {
        int i2 = 0;
        switch (i & 7) {
            case 0:
                if (this.limit - this.pos >= 10) {
                    while (i2 < 10) {
                        byte[] bArr = this.buffer;
                        int i3 = this.pos;
                        this.pos = i3 + 1;
                        if (bArr[i3] >= (byte) 0) {
                            return true;
                        }
                        i2++;
                    }
                    throw zzfie.zzdag();
                }
                while (i2 < 10) {
                    if (zzcyv() >= (byte) 0) {
                        return true;
                    }
                    i2++;
                }
                throw zzfie.zzdag();
            case 1:
                zzlk(8);
                return true;
            case 2:
                zzlk(zzcym());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzlk(4);
                return true;
            default:
                throw zzfie.zzdaj();
        }
        do {
            i2 = zzcxx();
            if (i2 != 0) {
            }
            zzlf(((i >>> 3) << 3) | 4);
            return true;
        } while (zzlg(i2));
        zzlf(((i >>> 3) << 3) | 4);
        return true;
    }

    public final int zzli(int i) throws zzfie {
        if (i < 0) {
            throw zzfie.zzdaf();
        }
        int zzcyq = zzcyq() + i;
        int i2 = this.zzpok;
        if (zzcyq > i2) {
            throw zzfie.zzdae();
        }
        this.zzpok = zzcyq;
        zzcyu();
        return i2;
    }

    public final void zzlj(int i) {
        this.zzpok = i;
        zzcyu();
    }

    public final void zzlk(int i) throws IOException {
        if (i >= 0 && i <= this.limit - this.pos) {
            this.pos += i;
        } else if (i < 0) {
            throw zzfie.zzdaf();
        } else {
            throw zzfie.zzdae();
        }
    }
}
