.class public Lm/e/huyen2/ac3;
.super Landroid/app/Activity;
.source "ac3.java"


# instance fields
.field img:Landroid/widget/ImageView;

.field img2:Landroid/widget/ImageView;

.field img3:Landroid/widget/ImageView;

.field img4:Landroid/widget/ImageView;

.field img5:Landroid/widget/ImageView;

.field img6:Landroid/widget/ImageView;

.field img7:Landroid/widget/ImageView;

.field img8:Landroid/widget/ImageView;

.field img9:Landroid/widget/ImageView;

.field t:Landroid/widget/TextView;

.field t2:Landroid/widget/TextView;

.field t3:Landroid/widget/TextView;

.field t4:Landroid/widget/TextView;

.field vi:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    const/high16 v1, 0x41a00000    # 20.0f

    .line 26
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 27
    const v0, 0x7f030019

    invoke-virtual {p0, v0}, Lm/e/huyen2/ac3;->setContentView(I)V

    .line 29
    const v0, 0x7f0a0078

    invoke-virtual {p0, v0}, Lm/e/huyen2/ac3;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lm/e/huyen2/ac3;->t:Landroid/widget/TextView;

    .line 30
    const v0, 0x7f0a007c

    invoke-virtual {p0, v0}, Lm/e/huyen2/ac3;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lm/e/huyen2/ac3;->t2:Landroid/widget/TextView;

    .line 31
    const v0, 0x7f0a007e

    invoke-virtual {p0, v0}, Lm/e/huyen2/ac3;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lm/e/huyen2/ac3;->t3:Landroid/widget/TextView;

    .line 32
    const v0, 0x7f0a007a

    invoke-virtual {p0, v0}, Lm/e/huyen2/ac3;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lm/e/huyen2/ac3;->t4:Landroid/widget/TextView;

    .line 33
    iget-object v0, p0, Lm/e/huyen2/ac3;->t:Landroid/widget/TextView;

    invoke-virtual {v0, v2, v1}, Landroid/widget/TextView;->setTextSize(IF)V

    .line 34
    iget-object v0, p0, Lm/e/huyen2/ac3;->t2:Landroid/widget/TextView;

    invoke-virtual {v0, v2, v1}, Landroid/widget/TextView;->setTextSize(IF)V

    .line 35
    iget-object v0, p0, Lm/e/huyen2/ac3;->t3:Landroid/widget/TextView;

    invoke-virtual {v0, v2, v1}, Landroid/widget/TextView;->setTextSize(IF)V

    .line 36
    iget-object v0, p0, Lm/e/huyen2/ac3;->t4:Landroid/widget/TextView;

    invoke-virtual {v0, v2, v1}, Landroid/widget/TextView;->setTextSize(IF)V

    .line 37
    const v0, 0x7f0a0077

    invoke-virtual {p0, v0}, Lm/e/huyen2/ac3;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lm/e/huyen2/ac3;->img:Landroid/widget/ImageView;

    .line 38
    const v0, 0x7f0a007d

    invoke-virtual {p0, v0}, Lm/e/huyen2/ac3;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lm/e/huyen2/ac3;->img2:Landroid/widget/ImageView;

    .line 40
    const v0, 0x7f0a007b

    invoke-virtual {p0, v0}, Lm/e/huyen2/ac3;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lm/e/huyen2/ac3;->img4:Landroid/widget/ImageView;

    .line 41
    const v0, 0x7f0a0079

    invoke-virtual {p0, v0}, Lm/e/huyen2/ac3;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lm/e/huyen2/ac3;->img5:Landroid/widget/ImageView;

    .line 68
    iget-object v0, p0, Lm/e/huyen2/ac3;->img:Landroid/widget/ImageView;

    new-instance v1, Lm/e/huyen2/ac3$1;

    invoke-direct {v1, p0}, Lm/e/huyen2/ac3$1;-><init>(Lm/e/huyen2/ac3;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 83
    iget-object v0, p0, Lm/e/huyen2/ac3;->img5:Landroid/widget/ImageView;

    new-instance v1, Lm/e/huyen2/ac3$2;

    invoke-direct {v1, p0}, Lm/e/huyen2/ac3$2;-><init>(Lm/e/huyen2/ac3;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 96
    iget-object v0, p0, Lm/e/huyen2/ac3;->img2:Landroid/widget/ImageView;

    new-instance v1, Lm/e/huyen2/ac3$3;

    invoke-direct {v1, p0}, Lm/e/huyen2/ac3$3;-><init>(Lm/e/huyen2/ac3;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 126
    iget-object v0, p0, Lm/e/huyen2/ac3;->img4:Landroid/widget/ImageView;

    new-instance v1, Lm/e/huyen2/ac3$4;

    invoke-direct {v1, p0}, Lm/e/huyen2/ac3$4;-><init>(Lm/e/huyen2/ac3;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 171
    return-void
.end method
