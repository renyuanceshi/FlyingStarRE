.class Lm/e/huyen2/danhsach$3;
.super Ljava/lang/Object;
.source "danhsach.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lm/e/huyen2/danhsach;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lm/e/huyen2/danhsach;


# direct methods
.method constructor <init>(Lm/e/huyen2/danhsach;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lm/e/huyen2/danhsach$3;->this$0:Lm/e/huyen2/danhsach;

    .line 184
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 187
    iget-object v0, p0, Lm/e/huyen2/danhsach$3;->this$0:Lm/e/huyen2/danhsach;

    invoke-virtual {v0}, Lm/e/huyen2/danhsach;->finish()V

    .line 188
    return-void
.end method
