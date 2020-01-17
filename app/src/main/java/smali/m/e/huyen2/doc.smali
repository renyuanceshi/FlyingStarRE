.class public Lm/e/huyen2/doc;
.super Landroid/app/Activity;
.source "doc.java"


# instance fields
.field b1:Landroid/widget/Button;

.field in:Ljava/io/InputStream;

.field t:Landroid/widget/TextView;

.field t2:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 12
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 16
    new-instance v0, Lm/e/huyen2/doc$1;

    invoke-direct {v0, p0}, Lm/e/huyen2/doc$1;-><init>(Lm/e/huyen2/doc;)V

    iput-object v0, p0, Lm/e/huyen2/doc;->in:Ljava/io/InputStream;

    .line 12
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 30
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 32
    const v2, 0x7f03001c

    invoke-virtual {p0, v2}, Lm/e/huyen2/doc;->setContentView(I)V

    .line 66
    const v2, 0x7f0a0078

    invoke-virtual {p0, v2}, Lm/e/huyen2/doc;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lm/e/huyen2/doc;->t:Landroid/widget/TextView;

    .line 67
    const v2, 0x7f0a00cb

    invoke-virtual {p0, v2}, Lm/e/huyen2/doc;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lm/e/huyen2/doc;->t2:Landroid/widget/TextView;

    .line 68
    invoke-virtual {p0}, Lm/e/huyen2/doc;->getWindow()Landroid/view/Window;

    move-result-object v2

    const/16 v3, 0x80

    invoke-virtual {v2, v3}, Landroid/view/Window;->addFlags(I)V

    .line 74
    iget-object v2, p0, Lm/e/huyen2/doc;->t2:Landroid/widget/TextView;

    const-string v3, "Xuan Kong Feng Shui"

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 77
    invoke-virtual {p0}, Lm/e/huyen2/doc;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f050001

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;

    move-result-object v2

    iput-object v2, p0, Lm/e/huyen2/doc;->in:Ljava/io/InputStream;

    .line 88
    :try_start_0
    iget-object v2, p0, Lm/e/huyen2/doc;->in:Ljava/io/InputStream;

    invoke-virtual {v2}, Ljava/io/InputStream;->available()I

    move-result v2

    new-array v0, v2, [B

    .line 89
    .local v0, "buffer":[B
    :cond_0
    iget-object v2, p0, Lm/e/huyen2/doc;->in:Ljava/io/InputStream;

    invoke-virtual {v2, v0}, Ljava/io/InputStream;->read([B)I

    move-result v2

    const/4 v3, -0x1

    if-ne v2, v3, :cond_0

    .line 90
    new-instance v1, Ljava/lang/String;

    invoke-direct {v1, v0}, Ljava/lang/String;-><init>([B)V

    .line 92
    .local v1, "jsontext":Ljava/lang/String;
    iget-object v2, p0, Lm/e/huyen2/doc;->t:Landroid/widget/TextView;

    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 100
    .end local v0    # "buffer":[B
    .end local v1    # "jsontext":Ljava/lang/String;
    :goto_0
    iget-object v2, p0, Lm/e/huyen2/doc;->t:Landroid/widget/TextView;

    const/4 v3, 0x1

    const/high16 v4, 0x41880000    # 17.0f

    invoke-virtual {v2, v3, v4}, Landroid/widget/TextView;->setTextSize(IF)V

    .line 101
    return-void

    .line 96
    :catch_0
    move-exception v2

    goto :goto_0
.end method
