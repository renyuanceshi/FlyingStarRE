.class Lm/e/huyen2/sua$3;
.super Ljava/lang/Object;
.source "sua.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lm/e/huyen2/sua;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lm/e/huyen2/sua;


# direct methods
.method constructor <init>(Lm/e/huyen2/sua;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lm/e/huyen2/sua$3;->this$0:Lm/e/huyen2/sua;

    .line 137
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 145
    iget-object v0, p0, Lm/e/huyen2/sua$3;->this$0:Lm/e/huyen2/sua;

    invoke-virtual {v0}, Lm/e/huyen2/sua;->finish()V

    .line 147
    return-void
.end method
