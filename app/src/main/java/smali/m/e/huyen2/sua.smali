.class public Lm/e/huyen2/sua;
.super Landroid/app/Activity;
.source "sua.java"


# instance fields
.field private adap2:Landroid/widget/ArrayAdapter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/widget/ArrayAdapter",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private adap3:Landroid/widget/ArrayAdapter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/widget/ArrayAdapter",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private adap4:Landroid/widget/ArrayAdapter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/widget/ArrayAdapter",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private adap5:Landroid/widget/ArrayAdapter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/widget/ArrayAdapter",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private adapter:Landroid/widget/ArrayAdapter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/widget/ArrayAdapter",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field b1:Landroid/widget/Button;

.field b2:Landroid/widget/Button;

.field co:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field col:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field data:[Ljava/lang/String;

.field data2:[Ljava/lang/String;

.field e:Landroid/widget/EditText;

.field e2:Landroid/widget/EditText;

.field giod:Ljava/lang/String;

.field giv:Ljava/lang/String;

.field private sp:Landroid/widget/Spinner;

.field private sp2:Landroid/widget/Spinner;

.field private sp3:Landroid/widget/Spinner;

.field private sp4:Landroid/widget/Spinner;

.field private sp5:Landroid/widget/Spinner;

.field t:Landroid/widget/TextView;

.field thudo:I

.field thuvan:I

.field x3:I


# direct methods
.method public constructor <init>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 22
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 28
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lm/e/huyen2/sua;->col:Ljava/util/ArrayList;

    .line 29
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lm/e/huyen2/sua;->co:Ljava/util/ArrayList;

    .line 33
    const/16 v0, 0x48

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "357-3"

    aput-object v1, v0, v3

    const-string v1, "4-7.5"

    aput-object v1, v0, v4

    const-string v1, "7.5-11"

    aput-object v1, v0, v5

    const-string v1, "12-18"

    aput-object v1, v0, v6

    const-string v1, "19-22.5"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string v2, "22.5-26"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "27-33"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "34-37.5"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "37.5-41"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "42-48"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "49-52.5"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "52.5-56"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "57-63"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "64-67.5"

    aput-object v2, v0, v1

    const/16 v1, 0xe

    const-string v2, "67.5-71"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    const-string v2, "72-78"

    aput-object v2, v0, v1

    const/16 v1, 0x10

    const-string v2, "79-82.5"

    aput-object v2, v0, v1

    const/16 v1, 0x11

    const-string v2, "82.5-86"

    aput-object v2, v0, v1

    const/16 v1, 0x12

    const-string v2, "87-93"

    aput-object v2, v0, v1

    const/16 v1, 0x13

    const-string v2, "94-97.5"

    aput-object v2, v0, v1

    const/16 v1, 0x14

    const-string v2, "97.5-101"

    aput-object v2, v0, v1

    const/16 v1, 0x15

    const-string v2, "102-108"

    aput-object v2, v0, v1

    const/16 v1, 0x16

    const-string v2, "109-112.5"

    aput-object v2, v0, v1

    const/16 v1, 0x17

    const-string v2, "112.5-116"

    aput-object v2, v0, v1

    const/16 v1, 0x18

    const-string v2, "117-123"

    aput-object v2, v0, v1

    const/16 v1, 0x19

    const-string v2, "124-127.5"

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    const-string v2, "127.5-131"

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    const-string v2, "132-138"

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    const-string v2, "139-142.5"

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    const-string v2, "142.5-146"

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    const-string v2, "147-153"

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    const-string v2, "154-157.5"

    aput-object v2, v0, v1

    const/16 v1, 0x20

    const-string v2, "157.5-161"

    aput-object v2, v0, v1

    const/16 v1, 0x21

    const-string v2, "162-168"

    aput-object v2, v0, v1

    const/16 v1, 0x22

    const-string v2, "169-172.5"

    aput-object v2, v0, v1

    const/16 v1, 0x23

    const-string v2, "172.5-176"

    aput-object v2, v0, v1

    const/16 v1, 0x24

    const-string v2, "177-183"

    aput-object v2, v0, v1

    const/16 v1, 0x25

    const-string v2, "184-187.5"

    aput-object v2, v0, v1

    const/16 v1, 0x26

    const-string v2, "187.5-191"

    aput-object v2, v0, v1

    const/16 v1, 0x27

    const-string v2, "192-198"

    aput-object v2, v0, v1

    const/16 v1, 0x28

    const-string v2, "199-202.5"

    aput-object v2, v0, v1

    const/16 v1, 0x29

    const-string v2, "202.5-206"

    aput-object v2, v0, v1

    const/16 v1, 0x2a

    const-string v2, "207-213"

    aput-object v2, v0, v1

    const/16 v1, 0x2b

    const-string v2, "214-217.5"

    aput-object v2, v0, v1

    const/16 v1, 0x2c

    const-string v2, "217.5-221"

    aput-object v2, v0, v1

    const/16 v1, 0x2d

    const-string v2, "222-228"

    aput-object v2, v0, v1

    const/16 v1, 0x2e

    const-string v2, "229-232.5"

    aput-object v2, v0, v1

    const/16 v1, 0x2f

    const-string v2, "232.5-236"

    aput-object v2, v0, v1

    const/16 v1, 0x30

    const-string v2, "237-243"

    aput-object v2, v0, v1

    const/16 v1, 0x31

    const-string v2, "244-247.5"

    aput-object v2, v0, v1

    const/16 v1, 0x32

    const-string v2, "247.5-251"

    aput-object v2, v0, v1

    const/16 v1, 0x33

    const-string v2, "252-258"

    aput-object v2, v0, v1

    const/16 v1, 0x34

    const-string v2, "259-262.5"

    aput-object v2, v0, v1

    const/16 v1, 0x35

    const-string v2, "262.5-266"

    aput-object v2, v0, v1

    const/16 v1, 0x36

    const-string v2, "267-273"

    aput-object v2, v0, v1

    const/16 v1, 0x37

    const-string v2, "274-277.5"

    aput-object v2, v0, v1

    const/16 v1, 0x38

    const-string v2, "277.5-281"

    aput-object v2, v0, v1

    const/16 v1, 0x39

    const-string v2, "282-288"

    aput-object v2, v0, v1

    const/16 v1, 0x3a

    const-string v2, "289-292.5"

    aput-object v2, v0, v1

    const/16 v1, 0x3b

    const-string v2, "292.5-296"

    aput-object v2, v0, v1

    const/16 v1, 0x3c

    const-string v2, "297-303"

    aput-object v2, v0, v1

    const/16 v1, 0x3d

    const-string v2, "304-307.5"

    aput-object v2, v0, v1

    const/16 v1, 0x3e

    const-string v2, "307.5-311"

    aput-object v2, v0, v1

    const/16 v1, 0x3f

    const-string v2, "312-318"

    aput-object v2, v0, v1

    const/16 v1, 0x40

    const-string v2, "319-322.5"

    aput-object v2, v0, v1

    const/16 v1, 0x41

    const-string v2, "322.5-326"

    aput-object v2, v0, v1

    const/16 v1, 0x42

    const-string v2, "327-333"

    aput-object v2, v0, v1

    const/16 v1, 0x43

    const-string v2, "334-337.5"

    aput-object v2, v0, v1

    const/16 v1, 0x44

    const-string v2, "337.5-341"

    aput-object v2, v0, v1

    const/16 v1, 0x45

    const-string v2, "342-348"

    aput-object v2, v0, v1

    const/16 v1, 0x46

    const-string v2, "349-352.5"

    aput-object v2, v0, v1

    const/16 v1, 0x47

    const-string v2, "352.5-356"

    aput-object v2, v0, v1

    iput-object v0, p0, Lm/e/huyen2/sua;->data2:[Ljava/lang/String;

    .line 34
    const/16 v0, 0x9

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "4(1924-1943)"

    aput-object v1, v0, v3

    const-string v1, "5(1944-1963)"

    aput-object v1, v0, v4

    const-string v1, "6(1964-1983)"

    aput-object v1, v0, v5

    const-string v1, "7(1984-2003)"

    aput-object v1, v0, v6

    const-string v1, "8(2004-2023)"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string v2, "9(2024-2043)"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "1(2044-2063)"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "2(2064-2083)"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "3(2084-2103)"

    aput-object v2, v0, v1

    iput-object v0, p0, Lm/e/huyen2/sua;->data:[Ljava/lang/String;

    .line 22
    return-void
.end method

.method static synthetic access$0(Lm/e/huyen2/sua;)Landroid/widget/Spinner;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lm/e/huyen2/sua;->sp:Landroid/widget/Spinner;

    return-object v0
.end method

.method static synthetic access$1(Lm/e/huyen2/sua;)Landroid/widget/Spinner;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lm/e/huyen2/sua;->sp2:Landroid/widget/Spinner;

    return-object v0
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 14
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 42
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 43
    const v10, 0x7f030033

    invoke-virtual {p0, v10}, Lm/e/huyen2/sua;->setContentView(I)V

    .line 44
    invoke-virtual {p0}, Lm/e/huyen2/sua;->getIntent()Landroid/content/Intent;

    move-result-object v8

    .line 45
    .local v8, "in22":Landroid/content/Intent;
    invoke-virtual {v8}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v4

    .line 46
    .local v4, "bun2":Landroid/os/Bundle;
    const-string v10, "giocz"

    invoke-virtual {v4, v10}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v10

    iput v10, p0, Lm/e/huyen2/sua;->x3:I

    .line 47
    const-string v10, "ghi"

    invoke-virtual {v4, v10}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v10

    iput-object v10, p0, Lm/e/huyen2/sua;->col:Ljava/util/ArrayList;

    .line 49
    iget-object v10, p0, Lm/e/huyen2/sua;->col:Ljava/util/ArrayList;

    iget v11, p0, Lm/e/huyen2/sua;->x3:I

    invoke-virtual {v10, v11}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/String;

    const-string v11, ","

    invoke-virtual {v10, v11}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 50
    .local v1, "a1":[Ljava/lang/String;
    const/4 v10, 0x1

    aget-object v10, v1, v10

    invoke-virtual {v10}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v6

    .line 51
    .local v6, "h":Ljava/lang/String;
    const-string v10, " "

    invoke-virtual {v6, v10}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 54
    .local v2, "a2":[Ljava/lang/String;
    const/4 v10, 0x0

    aget-object v10, v2, v10

    invoke-virtual {v10}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v5

    .line 55
    .local v5, "doso":Ljava/lang/String;
    const/4 v10, 0x2

    aget-object v10, v1, v10

    invoke-virtual {v10}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v9

    .line 56
    .local v9, "ph":Ljava/lang/String;
    const-string v10, " "

    invoke-virtual {v9, v10}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 57
    .local v3, "a5":[Ljava/lang/String;
    const/4 v10, 0x1

    aget-object v0, v3, v10

    .line 59
    .local v0, "a07":Ljava/lang/String;
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_0
    iget-object v10, p0, Lm/e/huyen2/sua;->data2:[Ljava/lang/String;

    array-length v10, v10

    if-lt v7, v10, :cond_0

    .line 66
    const/4 v7, 0x0

    :goto_1
    iget-object v10, p0, Lm/e/huyen2/sua;->data:[Ljava/lang/String;

    array-length v10, v10

    if-lt v7, v10, :cond_2

    .line 78
    const v10, 0x7f0a00ea

    invoke-virtual {p0, v10}, Lm/e/huyen2/sua;->findViewById(I)Landroid/view/View;

    move-result-object v10

    check-cast v10, Landroid/widget/EditText;

    iput-object v10, p0, Lm/e/huyen2/sua;->e2:Landroid/widget/EditText;

    .line 79
    iget-object v10, p0, Lm/e/huyen2/sua;->e2:Landroid/widget/EditText;

    const/4 v11, 0x0

    aget-object v11, v1, v11

    invoke-virtual {v10, v11}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 80
    const v10, 0x7f0a00c3

    invoke-virtual {p0, v10}, Lm/e/huyen2/sua;->findViewById(I)Landroid/view/View;

    move-result-object v10

    check-cast v10, Landroid/widget/Button;

    iput-object v10, p0, Lm/e/huyen2/sua;->b1:Landroid/widget/Button;

    .line 81
    const v10, 0x7f0a00eb

    invoke-virtual {p0, v10}, Lm/e/huyen2/sua;->findViewById(I)Landroid/view/View;

    move-result-object v10

    check-cast v10, Landroid/widget/Spinner;

    iput-object v10, p0, Lm/e/huyen2/sua;->sp:Landroid/widget/Spinner;

    .line 82
    const v10, 0x7f0a00ba

    invoke-virtual {p0, v10}, Lm/e/huyen2/sua;->findViewById(I)Landroid/view/View;

    move-result-object v10

    check-cast v10, Landroid/widget/Spinner;

    iput-object v10, p0, Lm/e/huyen2/sua;->sp2:Landroid/widget/Spinner;

    .line 96
    new-instance v10, Landroid/widget/ArrayAdapter;

    const v11, 0x7f030031

    const v12, 0x7f0a00d0

    iget-object v13, p0, Lm/e/huyen2/sua;->data:[Ljava/lang/String;

    invoke-direct {v10, p0, v11, v12, v13}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;II[Ljava/lang/Object;)V

    iput-object v10, p0, Lm/e/huyen2/sua;->adapter:Landroid/widget/ArrayAdapter;

    .line 97
    new-instance v10, Landroid/widget/ArrayAdapter;

    .line 98
    const v11, 0x7f030032

    const v12, 0x7f0a00e9

    iget-object v13, p0, Lm/e/huyen2/sua;->data2:[Ljava/lang/String;

    invoke-direct {v10, p0, v11, v12, v13}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;II[Ljava/lang/Object;)V

    .line 97
    iput-object v10, p0, Lm/e/huyen2/sua;->adap2:Landroid/widget/ArrayAdapter;

    .line 100
    iget-object v10, p0, Lm/e/huyen2/sua;->sp:Landroid/widget/Spinner;

    new-instance v11, Lm/e/huyen2/sua$1;

    invoke-direct {v11, p0}, Lm/e/huyen2/sua$1;-><init>(Lm/e/huyen2/sua;)V

    invoke-virtual {v10, v11}, Landroid/widget/Spinner;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V

    .line 116
    iget-object v10, p0, Lm/e/huyen2/sua;->sp:Landroid/widget/Spinner;

    iget-object v11, p0, Lm/e/huyen2/sua;->adapter:Landroid/widget/ArrayAdapter;

    invoke-virtual {v10, v11}, Landroid/widget/Spinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 117
    iget-object v10, p0, Lm/e/huyen2/sua;->sp2:Landroid/widget/Spinner;

    new-instance v11, Lm/e/huyen2/sua$2;

    invoke-direct {v11, p0}, Lm/e/huyen2/sua$2;-><init>(Lm/e/huyen2/sua;)V

    invoke-virtual {v10, v11}, Landroid/widget/Spinner;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V

    .line 131
    iget-object v10, p0, Lm/e/huyen2/sua;->sp2:Landroid/widget/Spinner;

    iget-object v11, p0, Lm/e/huyen2/sua;->adap2:Landroid/widget/ArrayAdapter;

    invoke-virtual {v10, v11}, Landroid/widget/Spinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 133
    iget-object v10, p0, Lm/e/huyen2/sua;->sp:Landroid/widget/Spinner;

    iget v11, p0, Lm/e/huyen2/sua;->thuvan:I

    invoke-virtual {v10, v11}, Landroid/widget/Spinner;->setSelection(I)V

    .line 134
    iget-object v10, p0, Lm/e/huyen2/sua;->sp2:Landroid/widget/Spinner;

    iget v11, p0, Lm/e/huyen2/sua;->thudo:I

    invoke-virtual {v10, v11}, Landroid/widget/Spinner;->setSelection(I)V

    .line 136
    const v10, 0x7f0a00ca

    invoke-virtual {p0, v10}, Lm/e/huyen2/sua;->findViewById(I)Landroid/view/View;

    move-result-object v10

    check-cast v10, Landroid/widget/Button;

    iput-object v10, p0, Lm/e/huyen2/sua;->b2:Landroid/widget/Button;

    .line 137
    iget-object v10, p0, Lm/e/huyen2/sua;->b2:Landroid/widget/Button;

    new-instance v11, Lm/e/huyen2/sua$3;

    invoke-direct {v11, p0}, Lm/e/huyen2/sua$3;-><init>(Lm/e/huyen2/sua;)V

    invoke-virtual {v10, v11}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 150
    iget-object v10, p0, Lm/e/huyen2/sua;->b1:Landroid/widget/Button;

    new-instance v11, Lm/e/huyen2/sua$4;

    invoke-direct {v11, p0}, Lm/e/huyen2/sua$4;-><init>(Lm/e/huyen2/sua;)V

    invoke-virtual {v10, v11}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 248
    iget-object v10, p0, Lm/e/huyen2/sua;->b1:Landroid/widget/Button;

    const/4 v11, 0x1

    const/high16 v12, 0x41700000    # 15.0f

    invoke-virtual {v10, v11, v12}, Landroid/widget/Button;->setTextSize(IF)V

    .line 249
    iget-object v10, p0, Lm/e/huyen2/sua;->b2:Landroid/widget/Button;

    const/4 v11, 0x1

    const/high16 v12, 0x41700000    # 15.0f

    invoke-virtual {v10, v11, v12}, Landroid/widget/Button;->setTextSize(IF)V

    .line 250
    return-void

    .line 60
    :cond_0
    iget-object v10, p0, Lm/e/huyen2/sua;->data2:[Ljava/lang/String;

    aget-object v10, v10, v7

    invoke-virtual {v5, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_1

    .line 61
    iput v7, p0, Lm/e/huyen2/sua;->thudo:I

    .line 59
    :cond_1
    add-int/lit8 v7, v7, 0x1

    goto/16 :goto_0

    .line 67
    :cond_2
    iget-object v10, p0, Lm/e/huyen2/sua;->data:[Ljava/lang/String;

    aget-object v10, v10, v7

    invoke-virtual {v0, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_3

    .line 68
    iput v7, p0, Lm/e/huyen2/sua;->thuvan:I

    .line 66
    :cond_3
    add-int/lit8 v7, v7, 0x1

    goto/16 :goto_1
.end method
