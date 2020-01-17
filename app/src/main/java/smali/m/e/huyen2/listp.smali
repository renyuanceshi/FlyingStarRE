.class public Lm/e/huyen2/listp;
.super Landroid/widget/ArrayAdapter;
.source "listp.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field private final context:Landroid/app/Activity;

.field private final item:[Ljava/lang/String;

.field so:I


# direct methods
.method public constructor <init>(Landroid/app/Activity;[Ljava/lang/String;I)V
    .locals 1
    .param p1, "context"    # Landroid/app/Activity;
    .param p2, "item"    # [Ljava/lang/String;
    .param p3, "sol"    # I

    .prologue
    .line 22
    const v0, 0x7f030020

    invoke-direct {p0, p1, v0, p2}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I[Ljava/lang/Object;)V

    .line 24
    iput p3, p0, Lm/e/huyen2/listp;->so:I

    .line 25
    iput-object p1, p0, Lm/e/huyen2/listp;->context:Landroid/app/Activity;

    .line 26
    iput-object p2, p0, Lm/e/huyen2/listp;->item:[Ljava/lang/String;

    .line 28
    return-void
.end method


# virtual methods
.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "position"    # I
    .param p2, "view"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "ViewHolder",
            "InflateParams"
        }
    .end annotation

    .prologue
    const/4 v5, 0x1

    .line 32
    iget-object v3, p0, Lm/e/huyen2/listp;->context:Landroid/app/Activity;

    invoke-virtual {v3}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    .line 33
    .local v0, "inflater":Landroid/view/LayoutInflater;
    const v3, 0x7f030020

    const/4 v4, 0x0

    invoke-virtual {v0, v3, v4, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 35
    .local v1, "rowView":Landroid/view/View;
    const v3, 0x7f0a00d1

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 36
    .local v2, "txt":Landroid/widget/TextView;
    iget-object v3, p0, Lm/e/huyen2/listp;->item:[Ljava/lang/String;

    aget-object v3, v3, p1

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 37
    const/high16 v3, 0x41700000    # 15.0f

    invoke-virtual {v2, v5, v3}, Landroid/widget/TextView;->setTextSize(IF)V

    .line 38
    iget v3, p0, Lm/e/huyen2/listp;->so:I

    if-ne v3, v5, :cond_0

    .line 39
    const-string v3, "#8C001A"

    invoke-static {v3}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 42
    :cond_0
    return-object v1
.end method
