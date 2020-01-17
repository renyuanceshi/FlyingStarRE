.class public Lm/e/huyen2/luu;
.super Landroid/app/Activity;
.source "luu.java"


# instance fields
.field b1:Landroid/widget/Button;

.field b2:Landroid/widget/Button;

.field b3:Landroid/widget/Button;

.field chi:Ljava/lang/String;

.field e:Landroid/widget/EditText;

.field list:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 26
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 27
    const v2, 0x7f030021

    invoke-virtual {p0, v2}, Lm/e/huyen2/luu;->setContentView(I)V

    .line 32
    const v2, 0x7f0a00d3

    invoke-virtual {p0, v2}, Lm/e/huyen2/luu;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/EditText;

    iput-object v2, p0, Lm/e/huyen2/luu;->e:Landroid/widget/EditText;

    .line 33
    const v2, 0x7f0a00c3

    invoke-virtual {p0, v2}, Lm/e/huyen2/luu;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    iput-object v2, p0, Lm/e/huyen2/luu;->b1:Landroid/widget/Button;

    .line 34
    invoke-virtual {p0}, Lm/e/huyen2/luu;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 35
    .local v1, "in22":Landroid/content/Intent;
    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 36
    .local v0, "bun2":Landroid/os/Bundle;
    const-string v2, "giocz"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lm/e/huyen2/luu;->chi:Ljava/lang/String;

    .line 38
    iget-object v2, p0, Lm/e/huyen2/luu;->b1:Landroid/widget/Button;

    new-instance v3, Lm/e/huyen2/luu$1;

    invoke-direct {v3, p0}, Lm/e/huyen2/luu$1;-><init>(Lm/e/huyen2/luu;)V

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 80
    const v2, 0x7f0a00ca

    invoke-virtual {p0, v2}, Lm/e/huyen2/luu;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    iput-object v2, p0, Lm/e/huyen2/luu;->b2:Landroid/widget/Button;

    .line 81
    iget-object v2, p0, Lm/e/huyen2/luu;->b2:Landroid/widget/Button;

    new-instance v3, Lm/e/huyen2/luu$2;

    invoke-direct {v3, p0}, Lm/e/huyen2/luu$2;-><init>(Lm/e/huyen2/luu;)V

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 91
    return-void
.end method
