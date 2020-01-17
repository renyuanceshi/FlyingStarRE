.class public Lm/e/huyen2/danhsach;
.super Landroid/app/Activity;
.source "danhsach.java"


# static fields
.field static ag:I


# instance fields
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

.field az:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field b1:Landroid/widget/Button;

.field b2:Landroid/widget/Button;

.field b3:Landroid/widget/Button;

.field b4:Landroid/widget/Button;

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

.field col2:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field dem:I

.field e:Landroid/widget/EditText;

.field private lv:Landroid/widget/ListView;

.field na6:Ljava/lang/String;

.field t:Landroid/widget/TextView;

.field t2:Landroid/widget/TextView;

.field t3:Landroid/widget/TextView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    const/4 v0, 0x0

    sput v0, Lm/e/huyen2/danhsach;->ag:I

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 27
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 33
    const/4 v0, 0x0

    iput v0, p0, Lm/e/huyen2/danhsach;->dem:I

    .line 47
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lm/e/huyen2/danhsach;->az:Ljava/util/ArrayList;

    .line 48
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lm/e/huyen2/danhsach;->col2:Ljava/util/ArrayList;

    .line 50
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lm/e/huyen2/danhsach;->col:Ljava/util/ArrayList;

    .line 27
    return-void
.end method

.method static synthetic access$0(Lm/e/huyen2/danhsach;)Landroid/widget/ListView;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lm/e/huyen2/danhsach;->lv:Landroid/widget/ListView;

    return-object v0
.end method

.method static synthetic access$1(Lm/e/huyen2/danhsach;)Landroid/widget/ArrayAdapter;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lm/e/huyen2/danhsach;->adapter:Landroid/widget/ArrayAdapter;

    return-object v0
.end method


# virtual methods
.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 6
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/4 v5, 0x1

    .line 284
    if-ne p1, v5, :cond_1

    .line 285
    const/4 v2, 0x3

    if-ne p2, v2, :cond_0

    .line 286
    iget-object v2, p0, Lm/e/huyen2/danhsach;->col:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    .line 287
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 288
    .local v1, "bun":Landroid/os/Bundle;
    const-string v2, "iz"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v2

    iput-object v2, p0, Lm/e/huyen2/danhsach;->col:Ljava/util/ArrayList;

    .line 289
    new-instance v2, Lm/e/huyen2/li2;

    iget-object v3, p0, Lm/e/huyen2/danhsach;->col:Ljava/util/ArrayList;

    invoke-direct {v2, p0, v3}, Lm/e/huyen2/li2;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;)V

    iput-object v2, p0, Lm/e/huyen2/danhsach;->adapter:Landroid/widget/ArrayAdapter;

    .line 292
    iget-object v2, p0, Lm/e/huyen2/danhsach;->lv:Landroid/widget/ListView;

    iget-object v3, p0, Lm/e/huyen2/danhsach;->adapter:Landroid/widget/ArrayAdapter;

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 293
    iget-object v2, p0, Lm/e/huyen2/danhsach;->lv:Landroid/widget/ListView;

    sget v3, Lm/e/huyen2/danhsach;->ag:I

    invoke-virtual {v2, v3, v5}, Landroid/widget/ListView;->setItemChecked(IZ)V

    .line 296
    .end local v1    # "bun":Landroid/os/Bundle;
    :cond_0
    const/4 v2, 0x4

    if-ne p2, v2, :cond_1

    .line 297
    iget-object v2, p0, Lm/e/huyen2/danhsach;->col:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    .line 298
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 299
    .restart local v1    # "bun":Landroid/os/Bundle;
    const-string v2, "iz"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v2

    iput-object v2, p0, Lm/e/huyen2/danhsach;->col:Ljava/util/ArrayList;

    .line 301
    new-instance v2, Landroid/widget/ArrayAdapter;

    .line 302
    const v3, 0x1090005

    iget-object v4, p0, Lm/e/huyen2/danhsach;->col:Ljava/util/ArrayList;

    invoke-direct {v2, p0, v3, v4}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 301
    iput-object v2, p0, Lm/e/huyen2/danhsach;->adapter:Landroid/widget/ArrayAdapter;

    .line 303
    iget-object v2, p0, Lm/e/huyen2/danhsach;->lv:Landroid/widget/ListView;

    iget-object v3, p0, Lm/e/huyen2/danhsach;->adapter:Landroid/widget/ArrayAdapter;

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 304
    iget-object v2, p0, Lm/e/huyen2/danhsach;->col:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 305
    .local v0, "agg":I
    iget-object v2, p0, Lm/e/huyen2/danhsach;->lv:Landroid/widget/ListView;

    add-int/lit8 v3, v0, -0x1

    invoke-virtual {v2, v3, v5}, Landroid/widget/ListView;->setItemChecked(IZ)V

    .line 306
    add-int/lit8 v2, v0, -0x1

    sput v2, Lm/e/huyen2/danhsach;->ag:I

    .line 312
    .end local v0    # "agg":I
    .end local v1    # "bun":Landroid/os/Bundle;
    :cond_1
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 9
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/high16 v8, 0x41700000    # 15.0f

    const/4 v7, 0x1

    .line 56
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 58
    const v5, 0x7f03001b

    invoke-virtual {p0, v5}, Lm/e/huyen2/danhsach;->setContentView(I)V

    .line 73
    const v5, 0x7f0a00c8

    invoke-virtual {p0, v5}, Lm/e/huyen2/danhsach;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ListView;

    iput-object v5, p0, Lm/e/huyen2/danhsach;->lv:Landroid/widget/ListView;

    .line 74
    iget-object v5, p0, Lm/e/huyen2/danhsach;->lv:Landroid/widget/ListView;

    invoke-virtual {v5, v7}, Landroid/widget/ListView;->setChoiceMode(I)V

    .line 76
    const v5, 0x7f0a00d0

    invoke-virtual {p0, v5}, Lm/e/huyen2/danhsach;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, p0, Lm/e/huyen2/danhsach;->t:Landroid/widget/TextView;

    .line 77
    const v5, 0x7f0a00e9

    invoke-virtual {p0, v5}, Lm/e/huyen2/danhsach;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, p0, Lm/e/huyen2/danhsach;->t2:Landroid/widget/TextView;

    .line 78
    const-string v4, ""

    .line 81
    .local v4, "line":Ljava/lang/String;
    :try_start_0
    const-string v5, "danhsach.txt"

    invoke-virtual {p0, v5}, Lm/e/huyen2/danhsach;->openFileInput(Ljava/lang/String;)Ljava/io/FileInputStream;

    move-result-object v1

    .line 83
    .local v1, "In":Ljava/io/FileInputStream;
    new-instance v3, Ljava/io/InputStreamReader;

    invoke-direct {v3, v1}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    .line 84
    .local v3, "inputReader":Ljava/io/InputStreamReader;
    new-instance v0, Ljava/io/BufferedReader;

    invoke-direct {v0, v3}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 85
    .local v0, "BR":Ljava/io/BufferedReader;
    :goto_0
    invoke-virtual {v0}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_0

    .line 88
    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 100
    .end local v0    # "BR":Ljava/io/BufferedReader;
    .end local v1    # "In":Ljava/io/FileInputStream;
    .end local v3    # "inputReader":Ljava/io/InputStreamReader;
    :goto_1
    new-instance v5, Lm/e/huyen2/li2;

    iget-object v6, p0, Lm/e/huyen2/danhsach;->col:Ljava/util/ArrayList;

    invoke-direct {v5, p0, v6}, Lm/e/huyen2/li2;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;)V

    iput-object v5, p0, Lm/e/huyen2/danhsach;->adapter:Landroid/widget/ArrayAdapter;

    .line 101
    iget-object v5, p0, Lm/e/huyen2/danhsach;->lv:Landroid/widget/ListView;

    new-instance v6, Lm/e/huyen2/danhsach$1;

    invoke-direct {v6, p0}, Lm/e/huyen2/danhsach$1;-><init>(Lm/e/huyen2/danhsach;)V

    invoke-virtual {v5, v6}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 113
    iget-object v5, p0, Lm/e/huyen2/danhsach;->lv:Landroid/widget/ListView;

    iget-object v6, p0, Lm/e/huyen2/danhsach;->adapter:Landroid/widget/ArrayAdapter;

    invoke-virtual {v5, v6}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 115
    const v5, 0x7f0a00c5

    invoke-virtual {p0, v5}, Lm/e/huyen2/danhsach;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    iput-object v5, p0, Lm/e/huyen2/danhsach;->b3:Landroid/widget/Button;

    .line 116
    iget-object v5, p0, Lm/e/huyen2/danhsach;->b3:Landroid/widget/Button;

    new-instance v6, Lm/e/huyen2/danhsach$2;

    invoke-direct {v6, p0}, Lm/e/huyen2/danhsach$2;-><init>(Lm/e/huyen2/danhsach;)V

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 183
    const v5, 0x7f0a00c6

    invoke-virtual {p0, v5}, Lm/e/huyen2/danhsach;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    iput-object v5, p0, Lm/e/huyen2/danhsach;->b4:Landroid/widget/Button;

    .line 184
    iget-object v5, p0, Lm/e/huyen2/danhsach;->b4:Landroid/widget/Button;

    new-instance v6, Lm/e/huyen2/danhsach$3;

    invoke-direct {v6, p0}, Lm/e/huyen2/danhsach$3;-><init>(Lm/e/huyen2/danhsach;)V

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 196
    const v5, 0x7f0a00ca

    invoke-virtual {p0, v5}, Lm/e/huyen2/danhsach;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    iput-object v5, p0, Lm/e/huyen2/danhsach;->b2:Landroid/widget/Button;

    .line 197
    iget-object v5, p0, Lm/e/huyen2/danhsach;->b2:Landroid/widget/Button;

    new-instance v6, Lm/e/huyen2/danhsach$4;

    invoke-direct {v6, p0}, Lm/e/huyen2/danhsach$4;-><init>(Lm/e/huyen2/danhsach;)V

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 225
    const v5, 0x7f0a00c3

    invoke-virtual {p0, v5}, Lm/e/huyen2/danhsach;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    iput-object v5, p0, Lm/e/huyen2/danhsach;->b1:Landroid/widget/Button;

    .line 226
    iget-object v5, p0, Lm/e/huyen2/danhsach;->b1:Landroid/widget/Button;

    new-instance v6, Lm/e/huyen2/danhsach$5;

    invoke-direct {v6, p0}, Lm/e/huyen2/danhsach$5;-><init>(Lm/e/huyen2/danhsach;)V

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 277
    iget-object v5, p0, Lm/e/huyen2/danhsach;->b1:Landroid/widget/Button;

    invoke-virtual {v5, v7, v8}, Landroid/widget/Button;->setTextSize(IF)V

    .line 278
    iget-object v5, p0, Lm/e/huyen2/danhsach;->b2:Landroid/widget/Button;

    invoke-virtual {v5, v7, v8}, Landroid/widget/Button;->setTextSize(IF)V

    .line 279
    iget-object v5, p0, Lm/e/huyen2/danhsach;->b3:Landroid/widget/Button;

    invoke-virtual {v5, v7, v8}, Landroid/widget/Button;->setTextSize(IF)V

    .line 280
    iget-object v5, p0, Lm/e/huyen2/danhsach;->b4:Landroid/widget/Button;

    invoke-virtual {v5, v7, v8}, Landroid/widget/Button;->setTextSize(IF)V

    .line 281
    return-void

    .line 86
    .restart local v0    # "BR":Ljava/io/BufferedReader;
    .restart local v1    # "In":Ljava/io/FileInputStream;
    .restart local v3    # "inputReader":Ljava/io/InputStreamReader;
    :cond_0
    :try_start_1
    iget-object v5, p0, Lm/e/huyen2/danhsach;->col:Ljava/util/ArrayList;

    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0

    .line 90
    .end local v0    # "BR":Ljava/io/BufferedReader;
    .end local v1    # "In":Ljava/io/FileInputStream;
    .end local v3    # "inputReader":Ljava/io/InputStreamReader;
    :catch_0
    move-exception v2

    .line 91
    .local v2, "e":Ljava/io/IOException;
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    goto/16 :goto_1
.end method
